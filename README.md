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

At this moment, the code contains a base class in [SkiTracker.java](SkiTracker.java) without full business logic. This README describes the target functionality to be implemented next.

### Possible Data Structure (Draft)

- Student: student profile data and goals.
- TrainingSession: date, duration, session type, notes.
- ProgressRecord: skill scores and changes over time.

### Run

After implementing the logic, run it as a standard Java application:

```bash
javac SkiTracker.java
java SkiTracker
```

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

На даний момент у коді присутній базовий клас [SkiTracker.java](SkiTracker.java) без реалізованої логіки. Цей README описує цільовий функціонал, який слід реалізувати наступними кроками.

### Можлива структура даних (чернетка)

- Student: дані учня та його цілі.
- TrainingSession: дата, тривалість, тип заняття, нотатки.
- ProgressRecord: оцінки навичок і зміни в часі.

### Запуск

Після реалізації логіки запуск можливий як стандартний Java-застосунок:

```bash
javac SkiTracker.java
java SkiTracker
```
