# SkiTracker

## EN

SkiTracker is a ski instructor assistant application for managing students, tracking progress, and planning training sessions.

### Purpose

The application helps instructors with daily workflow:
- stores student profiles and skill-related data;
- keeps training history;
- tracks technique and endurance progress;
- supports planning of personalized next sessions.

### Program Features

1. Student Management
- Create, update, and delete student profiles.
- Store basic data: name, age, skiing level, and goals.

2. Training Journal
- Create a training entry with date and duration.
- Save session type: technique, speed, balance, endurance.
- Add instructor notes after each session.

3. Progress Tracking
- Evaluate key skills on a scale (for example, 1-10).
- View progress trends per student.
- Identify strengths and weak areas.

4. Session Planning
- Build an individual plan for the next session.
- Define short-term and long-term goals.
- Generate focus recommendations based on previous results.

5. Instructor Reporting
- Show a short summary per student.
- Show latest sessions and current training status.

### Current Project Status

 **Fully Implemented** — The application is complete with all core features:
- Student and session management (CRUD operations)
- JSON persistence with Gson library
- Service-layer architecture for clean separation of concerns
- Interactive menu UI with input validation
- Gradle build system

### Technical Stack

- **Language:** Java 17+
- **Build System:** Gradle 9.4.1
- **Persistence:** JSON (via Gson 2.11.0)
- **IDE:** VS Code with Language Support for Java

### Project Structure

```
SkiTracker/
├── app/                  # Application entry point
│   └── SkiTracker.java  # Main class (loads/saves persistence)
├── model/               # Domain models
│   ├── Student.java     # Student profile with validation
│   └── TrainingSession.java  # Session data model
├── service/             # Business logic layer
│   └── StudentService.java   # CRUD operations for students/sessions
├── ui/                  # User interface
│   └── Menu.java        # Interactive menu system
├── util/                # Utility classes
│   ├── JsonStorage.java # JSON read/write operations
│   └── Helpers.java     # Input validation helpers
├── data/                # Runtime persistent storage
│   └── students.json    # Student data (auto-created)
└── build.gradle         # Gradle configuration
```

### Data Structure

- **Student:** name, age, skiing level (1-10), objective level (1-10), and list of training sessions
- **TrainingSession:** date, time of session, session type, and instructor notes

### How to Build and Run

**Build the project:**
```bash
./gradlew build
```

**Run the application:**
```bash
./gradlew run
```

The application will:
1. Load existing student data from `data/students.json` (if exists)
2. Show interactive menu for managing students and sessions
3. Auto-save changes to JSON on exit

### Features Implementation

1.  Student Management — Add, view, remove students with validation
2.  Training Sessions — Add, view, remove training sessions per student
3.  Edit Sessions — Update session details (implemented in StudentService)
4.  Persistent Storage — JSON format with Gson serialization
5.  Input Validation — Age, level ranges, non-empty fields

## UA

SkiTracker — це програма для інструктора лиж, яка допомагає вести облік занять, прогресу учнів і планування тренувань.

### Призначення

Програма спрощує щоденну роботу інструктора:
- фіксує учнів і їхні параметри підготовки;
- зберігає історію тренувань;
- показує прогрес по техніці та витривалості;
- допомагає формувати індивідуальний план наступних занять.

### Функціонал програми

1. Облік учнів
- Додавання, редагування та видалення профілю учня.
- Збереження базових даних: ім'я, вік, рівень катання, цілі.

2. Журнал тренувань
- Створення запису тренування з датою та тривалістю.
- Фіксація типу заняття: техніка, швидкість, баланс, витривалість.
- Додавання нотаток інструктора після тренування.

3. Відстеження прогресу
- Оцінка ключових навичок за шкалою (наприклад, 1-10).
- Перегляд динаміки результатів по кожному учню.
- Визначення сильних і слабких сторін.

4. Планування занять
- Формування індивідуального плану на наступне тренування.
- Встановлення короткострокових і довгострокових цілей.
- Рекомендації по фокусу тренування на основі попередніх результатів.

5. Звітність для інструктора
- Короткий підсумок по кожному учню.
- Список останніх тренувань і поточний статус підготовки.

### Поточний стан проєкту

 **Повністю реалізовано** — Програма завершена з усіма основними функціями:
- Управління учнями та сеансами (операції CRUD)
- Збереження у JSON з бібліотекою Gson
- Архітектура сервісного шару для чистого розділення концепцій
- Інтерактивне меню з валідацією введення
- Система збірки Gradle

### Технічний стек

- **Мова:** Java 17+
- **Система збірки:** Gradle 9.4.1
- **Збереження даних:** JSON (через Gson 2.11.0)
- **IDE:** VS Code з Language Support for Java

### Структура проєкту

```
SkiTracker/
├── app/                  # Точка входу програми
│   └── SkiTracker.java  # Основний клас (завантажує/зберігає дані)
├── model/               # Доменні моделі
│   ├── Student.java     # Профіль учня з валідацією
│   └── TrainingSession.java  # Модель даних сеансу
├── service/             # Шар бізнес-логіки
│   └── StudentService.java   # Операції CRUD для учнів/сеансів
├── ui/                  # Користувацький інтерфейс
│   └── Menu.java        # Інтерактивне меню
├── util/                # Допоміжні класи
│   ├── JsonStorage.java # Зчитування/запис JSON
│   └── Helpers.java     # Валідація введення
├── data/                # Постійне сховище даних
│   └── students.json    # Дані учнів (створюється автоматично)
└── build.gradle         # Конфігурація Gradle
```

### Структура даних

- **Student:** ім'я, вік, рівень катання (1-10), цільовий рівень (1-10) та список тренувальних сеансів
- **TrainingSession:** дата, час сеансу, тип сеансу та нотатки інструктора

### Як зібрати та запустити

**Зібрати проект:**
```bash
./gradlew build
```

**Запустити програму:**
```bash
./gradlew run
```

Програма буде:
1. Завантажувати існуючі дані учнів з `data/students.json` (якщо існує)
2. Показувати інтерактивне меню для управління учнями та сеансами
3. Автоматично зберігати зміни у JSON при виході

### Реалізація функцій

1.  Управління учнями — Додавання, перегляд, видалення учнів з валідацією
2.  Тренувальні сеанси — Додавання, перегляд, видалення сеансів для кожного учня
3.  Редагування сеансів — Оновлення деталей сеансу (реалізовано в StudentService)
4.  Постійне збереження — JSON формат з серіалізацією Gson
5.  Валідація введення — Діапазони віку, рівнів, непусті поля
