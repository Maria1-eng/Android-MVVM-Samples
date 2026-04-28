# Android MVVM Samples

Android samples built with Jetpack Compose following the MVVM pattern, with StateFlow for reactive state management. Includes unit tests and UI tests.

## Samples

### Login
Login screen with real-time input validation using `Patterns.EMAIL_ADDRESS` and password rules. The ViewModel exposes state via `StateFlow` and handles the login action with `viewModelScope`. Validation logic is covered with unit tests using Robolectric.

### Listtodo
To-do list with add, remove, and checkbox functionality. Structured with a dedicated presentation layer separating ViewModel, Model, and UI. Uses `LazyColumn`, `Scaffold`, and `AlertDialog`. Covered with UI tests.

## Stack

Kotlin · Jetpack Compose · ViewModel · StateFlow · Coroutines · Material 3 · Robolectric · JUnit
