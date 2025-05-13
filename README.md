# deneme123-android

A native Android voting app (“E-Vote”) that allows students to view candidate profiles, securely cast their votes, and see real-time election results.

---

## Table of Contents

- [Features](#features)  
- [Architecture & Tech Stack](#architecture--tech-stack)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Build & Run](#build--run)  
- [Project Structure](#project-structure)  
- [Usage Guide](#usage-guide)  
- [Contributing](#contributing)  
- [License](#license)  

---

## 🚀 Features

| Feature                   | Details                                                                          |
|---------------------------|----------------------------------------------------------------------------------|
| View Candidates           | Browse list of candidates with photos and bios                                   |
| Secure Voting             | Cast vote using JWT authorization for one-time secure ballots                    |
| Real-Time Results         | See live vote tallies and percentage graphs after each vote                      |
| Council Updates & Feedback| Read announcements from the student council and submit quick feedback messages   |
| Button-Click Flow         | Each UI button navigates to its own screen (e.g., Profile → Settings, Vote → Confirmation) |

---

## 🏗 Architecture & Tech Stack

- **Language & UI:** Kotlin, ViewBinding, Material 3  
- **Architecture:** MVVM + LiveData  
- **Networking:** Retrofit + OkHttp + Moshi  
- **Navigation:** Jetpack Navigation Component  
- **Storage:** Room (for caching election data)  
- **Security:** JWT tokens stored in `SharedPreferences`  

---

## 🎬 Getting Started

### Prerequisites

- Android Studio Flamingo or newer  
- JDK 11  

### Build & Run

```bash
# Clone the repo
git clone https://github.com/DENIZSARIGUL22/deneme123-android.git
cd deneme123-android

# Open in Android Studio:
# 1. File → Open → select this folder
# 2. Sync Gradle & Build
# 3. Run on emulator or device
📂 Project Structure
bash
Kopyala
Düzenle
deneme123-android/
├── app/                   
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/evote/        # Kotlin source
│   │   │   └── res/                           # XML layouts & drawables
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── .gitignore
📱 Usage Guide
Launch App → see Login screen.

Login/Register → obtain JWT from backend.

Home Dashboard → tap View Candidates, Vote, Council Updates, Profile.

Vote → select candidate → confirm → see success toast.

Results → navigate to View Results to see live tally.

Settings → update profile or logout.

🤝 Contributing
Fork this repo & create a branch:

bash
Kopyala
Düzenle
git checkout -b feat/YourFeature
Make changes & commit:

bash
Kopyala
Düzenle
git commit -m "Add awesome feature"
Push & open PR:

bash
Kopyala
Düzenle
git push origin feat/YourFeature
📜 License
This project is licensed under the MIT License.

yaml
Kopyala
Düzenle

---

### README for `deneme123-backend` (Flask JWT-Secured API)

```markdown
# deneme123-backend

A Flask-based backend for the E-Vote Android app.  
Provides JWT-authenticated endpoints for user registration, login, voting, and result retrieval.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Setup & Run](#setup--run)  
- [API Reference](#api-reference)  
- [Contributing](#contributing)  
- [License](#license)  

---

## 🚀 Features

- **Authentication** – `/auth/register`, `/auth/login` with JWT  
- **Vote Casting** – `/vote` endpoint, enforces one-vote policy per user  
- **Result Retrieval** – `/results` returns current tallies  
- **Candidate Management** – protected `/candidates` CRUD for admin  
- **Announcements** – `/updates` for council news & `/feedback` to receive messages  

---

## 🏗 Tech Stack

- **Language:** Python 3.9+  
- **Framework:** Flask, Flask-JWT-Extended  
- **Database:** SQLite via SQLAlchemy ORM  
- **Migrations:** Flask-Migrate (Alembic)  
- **CORS:** Flask-CORS  

---

## 🎬 Getting Started

### Prerequisites

- Python 3.9 or higher  
- pip  

### Setup & Run

```bash
# Clone the repo
git clone https://github.com/DENIZSARIGUL22/deneme123-backend.git
cd deneme123-backend

# Create & activate venv
python -m venv venv
# Windows
venv\Scripts\activate
# macOS/Linux
# source venv/bin/activate

# Install dependencies
pip install -r requirements.txt

# Initialize database
flask db upgrade

# Run server
flask run --host=0.0.0.0 --port=5000
Base URL: http://localhost:5000/

🔌 API Reference
Method	Endpoint	Auth	Description
POST	/auth/register	–	Create a new user
POST	/auth/login	–	Login & receive JWT
GET	/auth/me	JWT	Get current user info
POST	/vote	JWT	Cast a vote for a candidate
GET	/results	JWT	Retrieve current vote tallies
GET	/candidates	JWT/admin	List all candidates
POST	/candidates	JWT/admin	Add a new candidate
PUT	/candidates/<id>	JWT/admin	Update candidate info
DELETE	/candidates/<id>	JWT/admin	Remove a candidate
GET	/updates	–	List council announcements
POST	/feedback	–	Submit a feedback message

🤝 Contributing
Fork & clone:

bash
Kopyala
Düzenle
git checkout -b feat/YourFeature
Implement & test your feature.

Commit & push, then open a Pull Request.

📜 License
This project is licensed under the MIT License.

Kopyala
Düzenle






