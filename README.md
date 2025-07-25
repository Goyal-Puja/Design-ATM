# 🏦 SecureBank ATM System

A modern ATM (Automated Teller Machine) system with both console and web interfaces, built using Java and Spring Boot.

## 🚀 Features

- **Modern Web UI**: Beautiful, responsive ATM interface
- **Complete ATM Operations**: Card insertion, PIN authentication, balance check, cash withdrawal
- **State Pattern Implementation**: Robust state management for ATM operations
- **Chain of Responsibility**: Smart cash withdrawal using different denominations
- **Real-time Status**: Live ATM status monitoring
- **Secure Authentication**: PIN-based security system

## 🎯 Demo Credentials

- **Card Number**: Any number will work (for demo purposes)
- **PIN**: `112211`
- **Available Balance**: ₹25,000
- **ATM Balance**: ₹50,000

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.2.0
- **Frontend**: HTML5, CSS3, JavaScript (ES6+)
- **Build Tool**: Maven
- **Design Patterns**: State Pattern, Chain of Responsibility, Singleton

## 📱 Screenshots

The web interface features:
- 🎨 Modern gradient design with dark theme
- 💳 Interactive card slot simulation
- 📱 Responsive mobile-friendly layout
- ⚡ Real-time transaction processing
- 🔒 Secure PIN entry with masking
- 💰 Multiple withdrawal amounts
- 📊 Live ATM status monitoring

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd design-atm
   ```

2. **Run with Maven**
   ```bash
   mvn spring-boot:run
   ```

3. **Access the Web Interface**
   - Open your browser
   - Navigate to: `http://localhost:8080`
   - Use the demo credentials above

### Running Console Version

To run the original console-based ATM:

```bash
mvn compile exec:java -Dexec.mainClass="Main"
```

## 🎮 How to Use

### Web Interface

1. **Insert Card**: Enter any card number and click "Insert Card"
2. **Enter PIN**: Use PIN `112211` to authenticate
3. **Select Operation**: Choose between:
   - Cash Withdrawal
   - Balance Inquiry
4. **Complete Transaction**: Follow the on-screen instructions
5. **Exit**: Safely eject your card

### Available Operations

- **💰 Cash Withdrawal**: Withdraw money in denominations of ₹100, ₹500, ₹2000
- **💳 Balance Inquiry**: Check your current account balance
- **📊 ATM Status**: View ATM cash reserves and status
- **🚪 Exit**: Safely end your session

## 🏗️ Architecture

### Design Patterns Used

1. **State Pattern**: ATM states (Idle, HasCard, Authenticated, etc.)
2. **Chain of Responsibility**: Cash withdrawal processing
3. **Singleton**: ATM instance management
4. **MVC**: Spring Boot controller-service architecture

### Project Structure

```
src/
├── main/
│   ├── java/
│   │   ├── com/atm/          # Spring Boot application
│   │   │   ├── controller/   # REST controllers
│   │   │   ├── service/      # Business logic
│   │   │   └── dto/         # Data transfer objects
│   │   └── LowLevelDesign/   # Original ATM implementation
│   │       └── DesignATM/    # Core ATM classes
│   └── resources/
│       ├── templates/        # Thymeleaf templates
│       └── application.properties
└── Main.java                 # Console application entry point
```

## 🔧 API Endpoints

The Spring Boot backend exposes these REST endpoints:

- `GET /` - Web interface
- `POST /api/insert-card` - Insert card
- `POST /api/authenticate` - PIN authentication
- `POST /api/select-operation` - Select transaction type
- `POST /api/withdraw` - Cash withdrawal
- `GET /api/balance` - Balance inquiry
- `GET /api/status` - ATM status
- `POST /api/exit` - Exit/logout

## 🧪 Testing

The application includes comprehensive error handling:

- Invalid PIN attempts
- Insufficient funds (ATM or account)
- Invalid withdrawal amounts
- Network connectivity issues
- Session timeout management

## 🚀 Future Enhancements

- [ ] Multiple user accounts and cards
- [ ] Transaction history
- [ ] Receipt generation
- [ ] Admin panel for ATM management
- [ ] Database integration
- [ ] Security enhancements (encryption, audit logs)
- [ ] Mobile app version

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📄 License

This project is for educational purposes and demonstrates ATM system design patterns.

---

**Enjoy exploring the SecureBank ATM System! 🏦✨**