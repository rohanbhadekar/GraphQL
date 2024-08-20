import React, { useState } from 'react';
import { ApolloClient, InMemoryCache, ApolloProvider, gql, useQuery, useSubscription } from '@apollo/client';
import './App.css';

const client = new ApolloClient({
    uri: '/graphql', // Using relative URI because of the proxy setup
    cache: new InMemoryCache(),
});

// Query to fetch credit card details using fragments and aliasing
const CREDIT_CARD_QUERY = gql`
    query GetCreditCardDetails($id: String!) {
        card: creditCard(id: $id) {
            ...CreditCardInfo
            rewards {
                ...RewardsInfo
            }
        }
    }
    fragment CreditCardInfo on CreditCard {
        cardId
        cardNumber
        cardType
        balance
        creditLimit
        cardHolderName
        expirationDate
        billingAddress
        issueDate
        interestRate
        status
    }
    fragment RewardsInfo on Rewards {
        points
        tier
        cashBackRate
        rewardsExpiryDate
        bonusEligible
        lastRedeemedDate
        pointsToNextTier
    }
`;

// Query to fetch transactions with a limit
const TRANSACTIONS_QUERY = gql`
    query GetTransactions($id: String!, $limit: Int!) {
        creditCard(id: $id) {
            transactions(limit: $limit) {
                transactionId
                date
                amount
                description
                merchantName
                category
                paymentMethod
                location
                currency
                isRefundable
            }
        }
    }
`;

// Subscription to listen for real-time updates to rewards points
const REWARDS_SUBSCRIPTION = gql`
    subscription OnRewardsUpdated($id: String!) {
        rewardsUpdated(id: $id) {
            points
            tier
            pointsToNextTier
        }
    }
`;

function CreditCardDetails({ cardId }) {
    const { loading, error, data } = useQuery(CREDIT_CARD_QUERY, {
        variables: { id: cardId },
    });

    const { data: subscriptionData } = useSubscription(REWARDS_SUBSCRIPTION, {
        variables: { id: cardId },
    });

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error :( {error.message}</p>;

    const { card } = data;

    return (
        <div>
            <h2>Credit Card Details</h2>
            <p><strong>Card Number:</strong> {card.cardNumber}</p>
            <p><strong>Card Type:</strong> {card.cardType}</p>
            <p><strong>Card Holder Name:</strong> {card.cardHolderName}</p>
            <p><strong>Balance:</strong> ${card.balance}</p>
            <p><strong>Credit Limit:</strong> ${card.creditLimit}</p>
            <p><strong>Expiration Date:</strong> {card.expirationDate}</p>
            <p><strong>Billing Address:</strong> {card.billingAddress}</p>
            <p><strong>Issue Date:</strong> {card.issueDate}</p>
            <p><strong>Interest Rate:</strong> {card.interestRate}%</p>
            <p><strong>Status:</strong> {card.status}</p>

            <h2>Rewards</h2>
            <p><strong>Points:</strong> {subscriptionData?.rewardsUpdated.points || card.rewards.points}</p>
            <p><strong>Tier:</strong> {subscriptionData?.rewardsUpdated.tier || card.rewards.tier}</p>
            <p><strong>Cash Back Rate:</strong> {card.rewards.cashBackRate}%</p>
            <p><strong>Rewards Expiry Date:</strong> {card.rewards.rewardsExpiryDate}</p>
            <p><strong>Bonus Eligible:</strong> {card.rewards.bonusEligible ? 'Yes' : 'No'}</p>
            <p><strong>Last Redeemed Date:</strong> {card.rewards.lastRedeemedDate}</p>
            <p><strong>Points to Next Tier:</strong> {subscriptionData?.rewardsUpdated.pointsToNextTier || card.rewards.pointsToNextTier}</p>
        </div>
    );
}

function Transactions({ cardId, transactionLimit }) {
    const { loading, error, data } = useQuery(TRANSACTIONS_QUERY, {
        variables: { id: cardId, limit: transactionLimit },
    });

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error :( {error.message}</p>;

    return (
        <div>
            <h2>Recent Transactions</h2>
            <ul>
                {data.creditCard.transactions.map(transaction => (
                    <li key={transaction.transactionId}>
                        <p><strong>Date:</strong> {transaction.date}</p>
                        <p><strong>Amount:</strong> ${transaction.amount}</p>
                        <p><strong>Description:</strong> {transaction.description}</p>
                        <p><strong>Merchant Name:</strong> {transaction.merchantName}</p>
                        <p><strong>Category:</strong> {transaction.category}</p>
                        <p><strong>Payment Method:</strong> {transaction.paymentMethod}</p>
                        <p><strong>Location:</strong> {transaction.location}</p>
                        <p><strong>Currency:</strong> {transaction.currency}</p>
                        <p><strong>Refundable:</strong> {transaction.isRefundable ? 'Yes' : 'No'}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}

function App() {
    const [activeTab, setActiveTab] = useState(1);
    const [cardId, setCardId] = useState('');
    const [transactionLimit, setTransactionLimit] = useState(5);

    return (
        <div className="App">
            <div className="tabs">
                <button onClick={() => setActiveTab(1)}>Credit Card Details & Rewards</button>
                <button onClick={() => setActiveTab(2)}>Transactions</button>
            </div>

            <div className="tab-content">
                <input
                    type="text"
                    placeholder="Enter Card ID"
                    value={cardId}
                    onChange={e => setCardId(e.target.value)}
                />
                {activeTab === 1 && cardId && <CreditCardDetails cardId={cardId} />}
                {activeTab === 2 && (
                    <>
                        <input
                            type="number"
                            placeholder="Number of Transactions"
                            value={transactionLimit}
                            onChange={e => setTransactionLimit(parseInt(e.target.value))}
                        />
                        {cardId && transactionLimit > 0 && (
                            <Transactions cardId={cardId} transactionLimit={transactionLimit} />
                        )}
                    </>
                )}
            </div>
        </div>
    );
}

export default function RootApp() {
    return (
        <ApolloProvider client={client}>
            <App />
        </ApolloProvider>
    );
}
