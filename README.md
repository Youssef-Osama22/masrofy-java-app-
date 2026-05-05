Masroofy - Budget Management System
CS251 – Software Engineering Project

---

📌 Project Overview
Masroofy is a console-based Java application developed as part of the CS251 Software Engineering course. The system allows users to manage their expenses, track spending, and control their budget through a simple and interactive command-line interface.

The application follows Object-Oriented Programming (OOP) principles and implements system design models from the Software Design Specification (SDS), including class diagrams and sequence diagrams.

---

👥 Team Members

- Nawal Mahmoud Abdel Alem
- Soussana Ishak Habib
- Abanob Ihab Marcos
- Youssef Osama Sami Azmi

---

🛠️ Technology Stack

- Language: Java
- Paradigm: Object-Oriented Programming (OOP)
- Data Storage: File-based persistence (Text file)
- Documentation Tool: JavaDoc
- Version Control: Git & GitHub

---

⚙️ System Features (Implemented User Stories)

The system implements the first 7 user stories defined in the SRS:

1. Add Expense
   
   - User enters category and amount
   - System creates an Expense object and stores it

2. View Expense History
   
   - Displays all recorded expenses with index

3. Edit Expense Category
   
   - User selects an expense and updates its category

4. Set Budget Limit
   
   - User defines a total budget for the cycle

5. Calculate Daily Budget Limit
   
   - System calculates recommended daily spending

6. Budget Notification
   
   - Warning message shown when 80% of budget is exceeded

7. Dashboard Display
   
   - Shows total spending and remaining budget

---

💾 Data Persistence

- Data is stored in a local file:
  masroofy_data.txt

- Stored data includes:
  
  - Budget limit
  - List of expenses (category, amount, date)

- On application start:
  
  - The system automatically loads previously saved data

👉 This ensures continuity between sessions without using a database.

---

🏗️ System Design Mapping

The implementation is based on the SDS document:

- Each class in the SDS is implemented in code:
  
  - User
  - Category
  - Expense
  - BudgetCycle
  - NotificationService
  - HistoryManager
  - Dashboard
  - Database

- Sequence diagrams are mapped into program logic through:
  
  - Menu-driven operations
  - Method calls inside the main workflow

---

📂 Project Structure

Project/
│
├── MasroofyApp.java         (Main application + logic)
├── masroofy_data.txt       (Generated data file)
├── README.txt
│
├── SDS.pdf
├── Presentation.pdf
├── GitHub_Screenshots.pdf
│
├── Documentation/          (Source comments - JavaDoc)
├── Generated_Docs/         (Generated JavaDoc HTML files)

---

▶️ How to Run

1. Open terminal / command prompt

2. Navigate to project directory

3. Compile:
   javac MasroofyApp.java

4. Run:
   java MasroofyApp

---

📘 Documentation

- All classes and methods are documented using JavaDoc comments
- Generated documentation is included in:
  Generated_Docs/

---

🔗 GitHub Repository
https://github.com/Youssef-Osama22/masrofy-java-app-.git

- The repository contains:
  - Source code
  - Commit history for all team members
  - Version control for development

---

📌 Notes

- The system follows clean code practices and OOP principles
- File-based storage is used instead of a database as allowed in requirements
- Implementation reflects the system design models (SDS)
- The application is console-based (no GUI) as per project scope

---
