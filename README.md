# 🛒 EchoCart – Full-Stack E-Commerce Platform
<p align="center"> <img src="https://img.shields.io/badge/Status-Live-success?style=for-the-badge"/> <img src="https://img.shields.io/badge/Cloud-AWS-orange?style=for-the-badge&logo=amazonaws"/> <img src="https://img.shields.io/badge/Backend-Spring%20Boot-green?style=for-the-badge&logo=spring"/> <img src="https://img.shields.io/badge/Frontend-HTML%20%7C%20CSS%20%7C%20JS-blue?style=for-the-badge"/> </p>
🚀 EchoCart is a production-ready full-stack e-commerce web application designed and deployed on AWS Cloud.
The project demonstrates real-world backend architecture, cloud deployment, REST APIs, and frontend-backend integration.

✅ Frontend + Backend + Database — all hosted on AWS

## 🌐 Live Project Links (AWS Deployed)

🔗 GitHub Repository: [link](https://github.com/mr-piyushkr/EchoCart.git)

🌐 Frontend (AWS S3 Static Website): [link](http://echocart-frontend-2024.s3-website.eu-north-1.amazonaws.com/)

🔗 Backend Base API (AWS EC2): [link](http://13.51.13.143:8080/)

🔗 Health Check API: [link](http://13.51.13.143:8080/health)

## ✨ Key Features
👤 User Management
- User registration & login
- Role-based access control (Admin / Customer)

📦 Product Management
- Product CRUD operations
- Dynamic product listing

🛒 Cart System
- Add / remove items
- Real-time cart updates

📑 Order Management
- Place orders
- Order summary & tracking

💳 Payment Module
- Payment processing simulation
- Order payment status tracking

🧑‍💼 Admin Panel
- Manage users
- Manage products & orders

## 🧱 Tech Stack
🔙 Backend
<p> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="30"/> Java &nbsp;&nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="30"/> Spring Boot &nbsp;&nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="30"/> MySQL &nbsp;&nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/hibernate/hibernate-original.svg" height="30"/> JPA / Hibernate </p>
🎨 Frontend
<p> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" height="30"/> HTML5 &nbsp;&nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" height="30"/> CSS3 &nbsp;&nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" height="30"/> JavaScript &nbsp;&nbsp; <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bootstrap/bootstrap-original.svg" height="30"/> Bootstrap </p>
☁️ Cloud & DevOps
<p> <img src="https://img.shields.io/badge/AWS-EC2-orange?logo=amazonaws"/> <img src="https://img.shields.io/badge/AWS-S3-blue?logo=amazonaws"/> <img src="https://img.shields.io/badge/AWS-RDS-green?logo=amazonaws"/> <img src="https://img.shields.io/badge/Docker-Containerized-blue?logo=docker"/> </p>
🛠 Tools & Architecture
<p> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" height="28"/> Git &nbsp; 
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" height="28"/> GitHub &nbsp; 
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postman/postman-original.svg" height="28"/> Postman &nbsp; <img src="https://img.shields.io/badge/Maven-Build%20Tool-blue?logo=apachemaven"/> <img src="https://img.shields.io/badge/REST-API-green"/> <img src="https://img.shields.io/badge/MVC-Architecture-orange"/> <img src="https://img.shields.io/badge/Postman-API%20Testing-orange?logo=postman"/> </p>

## 📂 Project Structure

```bash
EchoCart
│
├── E-Commerce Backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/echocart/backend/
│   │   │   │       ├── config/
│   │   │   │       ├── controller/
│   │   │   │       ├── entity/
│   │   │   │       ├── repository/
│   │   │   │       ├── service/
│   │   │   │       └── EchoCart.java
│   │   │   └── resources/
│   │   │       ├── application.properties
│   │   │       ├── application-prod.properties
│   │   │       └── application-local.properties
│   │   └── test/
│   ├── Dockerfile
│   └── pom.xml
│
├── E-Commerce Frontend/
│   ├── assets/
│   │   ├── icons/
│   │   └── images/
│   ├── js/
│   │   ├── admin.js
│   │   ├── cart.js
│   │   ├── config.js
│   │   ├── customer.js
│   │   ├── main.js
│   │   ├── order-summary.js
│   │   └── product.js
│   ├── vendor/bootstrap/
│   ├── admin.html
│   ├── customer.html
│   ├── index.html
│   ├── order-summary.html
│   ├── style.css
│   └── vercel.json
│
├── LICENSE
└── README.md
```

## 🏗️ Deployment Architecture (AWS)
```
User Browser
     |
     |----> AWS S3 (Frontend - Static Website)
     |
     |----> AWS EC2 (Spring Boot Backend - Dockerized)
     |
     |----> AWS RDS (MySQL Database)
```
- ✔ CORS enabled
- ✔ Production-ready configuration
- ✔ Dockerized backend

## 🔗 API Modules
| Module | Description |
|--------|------------|
| 👤 User | User registration, login, roles |
| 📦 Product | Product CRUD operations |
| 🛒 Cart | Cart management |
| 📑 Order | Order placement & tracking |
| 💳 Payment | Payment processing |


## ▶️ How to Run the Project

### 🌐 Live Deployment
**Frontend:** [Live Website](http://echocart-frontend-2024.s3-website.eu-north-1.amazonaws.com/)  
**Backend API:** [http://13.51.13.143:8080/api](http://13.51.13.143:8080/)

### 🛠 Local Development

#### Backend Setup
```bash
cd "E-Commerce Backend"
mvn clean install
mvn spring-boot:run
```

#### Frontend Setup
```bash
cd "E-Commerce Frontend"
# Simply open index.html in browser
# Or use live server
```

### 🚀 AWS Deployment

#### Backend (AWS EC2 + Docker)
```bash
# Clone repository
git clone https://github.com/mr-piyushkr/EchoCart.git
cd EchoCart/"E-Commerce Backend"
```
```bash
# Build and run with Docker
sudo docker build -t echocart-backend .
sudo docker run -d -p 8080:8080 echocart-backend
```
#### Frontend (AWS S3)
- Static website hosting on AWS S3
- Manual upload or automated deployment

#### Database (AWS RDS MySQL)
- Production database hosted on AWS RDS
- Configured for high availability


## 🧪 Testing
- API tested using Postman
- Backend includes JUnit test cases


## 📸 Screens & UI
- ✔ Clean UI for customers
- ✔ Separate admin dashboard
- ✔ Responsive design
- ✔ **Live Demo Available** - [Try it now!](http://echocart-frontend-2024.s3-website.eu-north-1.amazonaws.com/)

## 🎆 Deployment Architecture
- **Frontend:** Deployed on AWS S3 Static Website Hosting
- **Backend:** Containerized with Docker and deployed on AWS EC2
- **Database:** AWS RDS MySQL for production data
- **API:** RESTful services with CORS enabled for cross-origin requests

## 🎯 Future Enhancements
- 🔐 JWT Authentication
- 💰 Real payment gateway integration
- 📊 Admin analytics dashboard
- 📱 Full mobile responsiveness
- ☁️ ~~Deployment on AWS Cloud~~ ✅ **COMPLETED**
- 🔄 CI/CD Pipeline with GitHub Actions
- 🔍 Advanced search and filtering
- 📧 Email notifications for orders


## 🤝 Contribution
Contributions, issues, and feature requests are welcome!

Feel free to fork this repo and submit a PR.


## ⭐ Show Your Support
If you like this project, give it a ⭐ on GitHub — it really helps!

## 📄 License
This project is licensed under the MIT License.

## 👨‍💻 Author

### Piyush Kumar
- 💼 Aspiring Software Developer
- 🚀 Passionate about Backend & Full-Stack Development

### To Connect
- Portfolio: [Link](https://my-portfolio-umber-zeta-11.vercel.app/)
- GitHub: [mr-piyushkr](https://github.com/mr-piyushkr)
- LinkedIn: [Piyush Kumar](https://linkedin.com/in/piyushkumar06)
- Email: 0602.piyushkumar@gmail.com
