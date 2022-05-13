# Conference-Management-App

Aplikacja (wyłącznie backend) dla strony do obsługi konferencji z 9 ścieżkami o 3 różnych godzinach.
Do startu należy uruchomić /src/main/java/com.sii.ConferenceManagementApp/ConferenceManagementAppApplication.

Działanie aplikacji testowałem w Postman.
Korzystałem z MySQL Workbench.

Ważne adresy url:
- strona głowna -> GET "localhost:8080/"
- rejestracja użytkownika -> POST "localhost:8080/register" (body -> raw) z przykładowymi danymi w formacie JSON:
   {
      "username":"test",
      "password":"test",
      "email":"test@gmail.com"
  }
- do zalogowania używam opcji "Basic Auth" (zakładka "Authorization") (GET) w Postmanie:
  - logowanie -> "localhost:8080/home"
- (zalogowany user) zapisanie użytkownika na daną ścieżkę -> PUT "localhost:8080/{lectureId}/users/{userId}" np. "localhost:8080/lectures/1/users/1"
- (zalogowany user) wylogowanie -> "localhost:8080/logout"
- istnieje możliwość stworzenia nowej ścieżki

Zdaję sobię sprawę z niedopracowania aplikacji, zamierzam ją dokończyć w najbliższym wolnym czasie, niezależnie od wyników rekrutacji.
Informacje o wersjach i bazie danych znajdują się w pom.xml i /src/main/java/com.sii.ConferenceManagementApp/resources/application.properties.

![image](https://user-images.githubusercontent.com/81679054/168327887-aa27e0eb-47de-4fdf-bf9f-abed0bc6447a.png)
