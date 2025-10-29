# EcommerceAppOOP
A simple e-commerce application written in Java, designed to demonstrate Object-Oriented
Programming (OOP) principles.
## Table of Contents
- Description
- Features
- Technologies & Dependencies
- Project Structure
- How to Run
- Example Usage
- Contributions
- License
## Description
This project is an educational prototype of an online store (e-commerce system) built with Java.
It focuses on:
- organizing the code into classes, interfaces, and packages for modularity,
- building a realistic object model ("Products", "Customers", "Orders", "Shopping Cart"),
- demonstrating OOP principles such as inheritance, polymorphism, encapsulation, and abstraction.
The main goal is educational: to show how a small-scale e-commerce system can be implemented
in Java without using complex web frameworks.
## Features
- Add and manage products in a catalog.
- View available products.
- Create and manage customer accounts.
- Add products to a shopping cart.
- Place an order and view the summary/total.
- (Optional) Manage product stock and inventory.
## Technologies & Dependencies
- **Java** (recommended version: JDK 11 or higher)
- (If applicable) Other libraries — check `pom.xml` or your build file if Maven/Gradle is used.
- No web server required — runs locally in the console or simple GUI.
## Project Structure
/src
■■ main
■ ■■ java
■ ■ ■■ com/yourcompany/ecommerce
■ ■ ■■ model (classes: Product, User, Order, Cart …)
■ ■ ■■ service (business logic: CatalogService, OrderService …)
■ ■ ■■ ui (simple interface: CLI or Swing GUI)
■ ■ ■■ util (helpers, utilities)
■■ test (optional, if unit tests exist)
.gitignore
README.md
## How to Run
1. Clone the repository:
git clone https://github.com/abel3324/EcommerceAppOOP.git
2. Navigate to the project directory:
cd EcommerceAppOOP
3. Compile the project:
javac -d out src/main/java/com/yourcompany/ecommerce/**/*.java
4. Run the application:
java -cp out com.yourcompany.ecommerce.Main
## Example Usage
Welcome to EcommerceAppOOP!
1) View the product catalog
2) Create or log into your account
3) Add items to your shopping cart
4) Checkout and confirm your order
Example:
- The catalog displays "Laptop XYZ" at a specific price.
- You add it to your cart.
- The total updates automatically.
- You confirm your purchase and receive a "Thank you!" message.
## Contributions
If you’d like to contribute:
- Fork the repository.
- Create a new branch: `feature/new-feature` or `fix/bug-name`.
- Commit your changes with clear messages.
- Open a pull request.
Any ideas for improvements — such as new features, better GUI, or additional logic — are
welcome!
## License
This project is licensed under the MIT License — see the `LICENSE` file for details.
© 2025 Abel Ursu. All rights reserved.
