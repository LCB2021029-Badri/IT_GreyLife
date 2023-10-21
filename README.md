# GreyLife IT Challenge - Loan Risk Assessment Solution

## Introduction

We propose to develop an AI-powered blockchain-based mobile application that will help TVS Credit to assess the risk of borrowers more accurately. This app collects essential borrower data, such as credit scores, income, and debt-to-income ratios, alongside non-traditional data in the form of a personality assessment test to anticipate financial behavior and risk tolerance levels.

An advanced ML model is then employed to determine whether an applicant qualifies as a low-risk candidate based on both traditional and non-traditional data. Notably, all borrower information will be securely stored in a decentralized blockchain network, ensuring the utmost security and privacy.

The app features user-friendly customer service assisted by automated systems and live human interaction to help loan borrowers clear doubts regarding the process, etc. Furthermore, this application goes beyond risk assessment by offering personalized risk mitigation guidance through customer service. This approach encompasses financial education and tailored recommendations aimed at improving the borrower's financial well-being. By adopting a proactive stance, the application empowers borrowers to progressively diminish their risk profile over time.

## Project Components

This Project is divided into 3 parts:

1. **Android**
2. **Machine Learning**
3. **Blockchain**

## Android App

The Android app has two sides:

- **Borrower**
- **Lender**

### Borrower's Side App Screenshots

Here are the borrower's side app screenshots placed side by side with slightly larger sizes:
### Login and Signup Screens:
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/99598fea-faf6-4ab5-9b80-a0f792be4b39" width="250" height="500" /> 
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/90d209ec-bd4d-411e-b8a4-c2d6e6a18642" width="250" height="500" />

### Home and Status Screens:
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/66307f31-8d88-43d5-aaff-2e4668377dda" width="250" height="500" /> 
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/04abe3fc-e931-438b-87f3-07ac0340489a" width="250" height="500" /> 
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/8197b229-1e40-4c5c-ba21-7f81b911a052" width="250" height="500" /> 

### SRIT Test and Risk Mitigation Screens:
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/9992a97c-15ee-4eaf-9f42-01009bf2a051" width="250" height="500" /> 
<img src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/9384f5ef-daf0-4544-9455-3299857edb88" width="250" height="500" /> 


## Machine Learning
### Overview
This project showcases the deployment of machine learning models using PCA (Principal Component Analysis) and XGBoost in Python. The models are trained and saved using pickle, then integrated into a Flask API. The Flask API is deployed on Railway, enabling users to send data from their mobile devices and receive predictions in real-time.
#### PCA (Principal Component Analysis)
Reduces the dimensionality of data, which can lead to faster training and improved model efficiency.
Helps in identifying important patterns and reducing noise in the data
It Reduces the input size from 11 to 3 and then process the result 
#### XGBoost
Provides high predictive accuracy and often outperforms other machine learning algorithms.
Allows for feature selection and can handle both numerical and categorical data
#### Ensemble Learning
Can lead to improved model performance, especially when the individual models have complementary strengths and weaknesses. Provides more robust predictions and is less sensitive to outliers or noise in the data.

### Workflow
<img width="645" alt="Screenshot 2023-10-18 at 10 03 25 AM" src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/1c7bc138-f297-49ad-8f08-d9e3bf2ff9cb">

### Sample Input and Output
<img width="1146" alt="Screenshot 2023-10-18 at 10 04 54 AM" src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/573e83b8-b82c-4729-af83-c8daa697bbd6">

## BlockChain
### Overview
This project focuses on the deployment of a Polygon Edge Chain on Amazon Web Services (AWS) using the Kaleido platform. The Polygon Edge Chain provides high-performance, low-latency infrastructure for blockchain applications. By successfully running a Polygon Edge Chain, this project aims to facilitate the development of efficient and scalable decentralized applications
### Consortium blockchain architecture
#### Node
Each node stores a copy of the blockchain and participates in the consensus process to validate transactions and add new blocks to the chain. There are two nodes running on polygon blockchain
#### Ledger
The ledger is the decentralized database that stores all of the transactions that occur on the blockchain
#### Smart Contracts
Smart contracts are self-executing contracts.These are used blockchain consortium architecture to automate the process of executing transactions on the blockchain. Kaleido's Smart Contract Management component simplifies Ethereum transaction submission and application development by providing clean RESTful interfaces for interaction with your smart contract methods.
##### Smart Contract WorkFlow
![Smart_Contract](https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/1c9ac823-b46a-42d7-8142-d2e9e607cefd)
#### Governance
Consortium blockchain governance is member-defined and adaptable, comprising rules and decision-making mechanisms tailored to specific use cases and goals.
Access to a private blockchain network is restricted to authorized parties only, and the network is not open to the public.
Private blockchains are preferred in enterprise use cases, such as supply chain management, to maintain greater network control.
#### Transaction Details
<img width="500" height="180" alt="Screenshot 2023-10-18 at 10 16 29 AM" src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/492e2ff9-7a86-4c19-97bb-39c69c974734">       <img width="500"  height="180" alt="Screenshot 2023-10-18 at 10 16 47 AM" src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/29187555-0711-42fa-90b1-48cecacbdaea">
<img width="493" alt="Screenshot 2023-10-18 at 10 17 07 AM" src="https://github.com/Smarshal21/GREY_LIFE_PREFINALE/assets/99678760/3078e9e4-5930-4655-9f00-7e17195c93ed">
## Features
- Authentication - Email-Password
- Dashboard
- Status Page (Application Status)
- Page for Uploading Documents and Data
- ML model Processed Output
- Secure Storage of data in Private Polygon BlockChain Deployed on Kaleido

## App Video Walkthrough



https://github.com/LCB2021029-Badri/IT_GreyLife/assets/96579549/2798a121-2be8-4242-8f64-f190ec49de26




## TECH STACK
- Kotlin
- XML
- Firebase
- Python
- Sklearn
- Flask
- Railway
- Solidity
- Kaleido
- Polygon-Edge
- JavaScript
## Github Profile
- Badri Akkala |[Github](https://github.com/LCB2021029-Badri)
