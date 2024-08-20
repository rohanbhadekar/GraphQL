import React, { useState } from 'react';
import { ApolloClient, InMemoryCache, ApolloProvider, gql, useQuery } from '@apollo/client';
import './App.css';

const client = new ApolloClient({
    uri: '/graphql', // Using relative URI because of the proxy setup
    cache: new InMemoryCache(),
});

function createCreditCardQuery(cardId) {
    return gql`
    query {
        creditCard(id: "${cardId}") {
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
            rewards {
                points
                tier
                cashBackRate
                rewardsExpiryDate
                bonusEligible
                lastRedeemedDate
                pointsToNextTier
            }
        }
    }`;
}

function createTransactionQuery(cardId, transactionLimit) {
    return gql`
    query {
        creditCard(id: "${cardId}") {
            transactions(limit: ${transactionLimit}) {
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
    }`;
}

function CreditCardDetails({ cardId }) {
    const { loading, error, data } = useQuery(createCreditCardQuery(cardId));

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error :(</p>;

    const { creditCard } = data;

    return (
        <div>
            <h2>Credit Card Details</h2>
            <p><strong>Card Number:</strong> {creditCard.cardNumber}</p>
            <p><strong>Card Type:</strong> {creditCard.cardType}</p>
            <p><strong>Card ID:</strong> {creditCard.cardId}</p>
            <p><strong>Balance:</strong> ${creditCard.balance}</p>
            <p><strong>Credit Limit:</strong> ${creditCard.creditLimit}</p>
            <p><strong>Card Holder Name:</strong> {creditCard.cardHolderName}</p>
            <p><strong>Expiration Date:</strong> {creditCard.expirationDate}</p>
            <p><strong>Billing Address:</strong> {creditCard.billingAddress}</p>
            <p><strong>Issue Date:</strong> {creditCard.issueDate}</p>
            <p><strong>Interest Rate:</strong> {creditCard.interestRate}%</p>
            <p><strong>Status:</strong> {creditCard.status}</p>

            <h2>Rewards</h2>
            <p><strong>Points:</strong> {creditCard.rewards.points}</p>
            <p><strong>Tier:</strong> {creditCard.rewards.tier}</p>
            <p><strong>Cash Back Rate:</strong> {creditCard.rewards.cashBackRate}%</p>
            <p><strong>Rewards Expiry Date:</strong> {creditCard.rewards.rewardsExpiryDate}</p>
            <p><strong>Bonus Eligible:</strong> {creditCard.rewards.bonusEligible ? 'Yes' : 'No'}</p>
            <p><strong>Last Redeemed Date:</strong> {creditCard.rewards.lastRedeemedDate}</p>
            <p><strong>Points to Next Tier:</strong> {creditCard.rewards.pointsToNextTier}</p>
        </div>
    );
}

function Transactions({ cardId, transactionLimit }) {
    const { loading, error, data } = useQuery(createTransactionQuery(cardId, transactionLimit));

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error :(</p>;

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

            {activeTab === 1 && (
                <div className="tab-content">
                    <h1>Credit Card Details & Rewards</h1>
                    <input
                        type="text"
                        placeholder="Enter Card ID"
                        value={cardId}
                        onChange={e => setCardId(e.target.value)}
                    />
                    {cardId && <CreditCardDetails cardId={cardId} />}
                </div>
            )}

            {activeTab === 2 && (
                <div className="tab-content">
                    <h1>Transactions</h1>
                    <input
                        type="number"
                        placeholder="Number of Transactions"
                        value={transactionLimit}
                        onChange={e => setTransactionLimit(parseInt(e.target.value))}
                    />
                    {cardId && transactionLimit > 0 && (
                        <Transactions cardId={cardId} transactionLimit={transactionLimit} />
                    )}
                </div>
            )}
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
