# PokeData Android App

Aplikasi Android sederhana untuk menampilkan daftar Pokémon menggunakan API publik dari PokeAPI.
Aplikasi ini dibuat menggunakan Jetpack Compose, Clean Architecture, serta memanfaatkan beberapa library modern Android seperti Hilt, Retrofit, Coroutine, dan Room Database.

Project ini dibuat sebagai bagian dari technical assessment Mobile Developer.

## Video



https://github.com/user-attachments/assets/4fcf2165-5872-4834-8037-cd16cb65752c



## Fitur Aplikasi

1. Autentikasi Lokal
- Halaman Login dan Register
- Data user disimpan menggunakan Room Database
- Validasi login menggunakan email dan password

2. Home Screen
- Menampilkan daftar 10 Pokémon
- Mendukung pagination ketika scroll ke bawah
- List hanya menampilkan nama Pokémon

3. Search Pokémon
- Tombol Search di AppBar
- User dapat mencari Pokémon berdasarkan nama
- Hasil pencarian langsung membuka Detail Screen

4. Detail Pokémon

Menampilkan informasi sederhana:
- Nama Pokémon
- Daftar Abilities

5. Profile Screen
Menampilkan data user yang sedang login:
- Nama
- Email
6. Logout

User dapat logout dari aplikasi melalui:
- Tombol logout di Home Screen

# Teknologi yang Digunakan

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Hilt Dependency Injection
- Retrofit
- Kotlin Coroutines & Flow
- Room Database
- Navigation Compose
- Material 3

# Arsitektur Project
Project ini menggunakan pendekatan Clean Architecture sederhana dengan struktur:
```text
app/
├── src/
│   ├── androidTest/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │       ├── zulhija_nanda/
│   │   │           ├── product/
│   │   │               ├── pokedata/
│   │   │                   ├── data/
│   │   │                   │   ├── local/
│   │   │                   │   │   ├── dao/
│   │   │                   │   │   │   ├── PokemonDao.kt
│   │   │                   │   │   │   └── UserDao.kt
│   │   │                   │   │   ├── AppDatabase.kt
│   │   │                   │   │   ├── PokemonEntity.kt
│   │   │                   │   │   └── UserEntity.kt
│   │   │                   │   ├── remote/
│   │   │                   │   │   ├── PokemonDetailResponse.kt
│   │   │                   │   │   └── PokemonListResponse.kt
│   │   │                   │   ├── repository/
│   │   │                   │       ├── PokemonRepository.kt
│   │   │                   │       └── UserRepository.kt
│   │   │                   ├── di/
│   │   │                   │   ├── DatabaseModule.kt
│   │   │                   │   ├── NetworkModule.kt
│   │   │                   │   └── RepositoryModule.kt
│   │   │                   ├── network/
│   │   │                   │   └── ApiService.kt
│   │   │                   ├── ui/
│   │   │                   │   ├── components/
│   │   │                   │   │   ├── BottomTab.kt
│   │   │                   │   │   └── SearchPokemonDialog.kt
│   │   │                   │   ├── screen/
│   │   │                   │   │   ├── DetailScreen.kt
│   │   │                   │   │   ├── DetailViewModel.kt
│   │   │                   │   │   ├── HomeScreen.kt
│   │   │                   │   │   ├── HomeViewModel.kt
│   │   │                   │   │   ├── LoginScreen.kt
│   │   │                   │   │   ├── LoginViewModel.kt
│   │   │                   │   │   ├── MainScreen.kt
│   │   │                   │   │   ├── ProfileScreen.kt
│   │   │                   │   │   ├── ProfileViewModel.kt
│   │   │                   │   │   ├── RegisterScreen.kt
│   │   │                   │   │   ├── RegisterViewModel.kt
│   │   │                   │   │   ├── SplashScreen.kt
│   │   │                   │   │   └── SplashViewModel.kt
│   │   │                   │   ├── theme/
│   │   │                   │       ├── Color.kt
│   │   │                   │       ├── Theme.kt
│   │   │                   │       └── Type.kt
│   │   │                   ├── utils/
│   │   │                   │   └── SessionManager.kt
│   │   │                   ├── AppNavigation.kt
│   │   │                   ├── MainActivity.kt
│   │   │                   └── MyApp.kt
│   │   └── AndroidManifest.xml
├── build.gradle.kts
└── proguard-rules.pro
```
# API yang Digunakan
Aplikasi ini menggunakan API publik dari:

https://pokeapi.co/

Endpoint utama yang digunakan:
```bash
GET https://pokeapi.co/api/v2/pokemon
GET https://pokeapi.co/api/v2/pokemon/{name}
```

# Library yang Digunakan

Library	

Hilt	-> Dependency Injection

Retrofit	-> Networking API

Room	-> Local Database

Coroutines	-> Asynchronous programming

Navigation Compose	-> Navigasi antar screen

Material3	-> UI Design

# Catatan

- Aplikasi ini tidak menampilkan gambar Pokémon sesuai dengan requirement.

- Data user disimpan secara lokal menggunakan Room.

- Aplikasi tetap dapat berjalan walaupun API tidak memuat gambar.
