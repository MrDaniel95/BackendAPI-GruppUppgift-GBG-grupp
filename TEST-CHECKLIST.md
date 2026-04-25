# Testchecklista – JWT Autentisering

## 1. JWT Login
- [ ] Öppna frontend på http://localhost:8080
- [ ] Logga in med username: `test` och password: `1234`
- [ ] Kontrollera att en token returneras i svaret
- [ ] Förväntat: Token är en lång sträng i formatet `xxxxx.yyyyy.zzzzz`

## 2. Skyddad endpoint – GET /private
- [ ] Anropa GET /private **med** token i headern:
  `Authorization: Bearer <din-token>`
- [ ] Förväntat: Får svar 200 OK
- [ ] Anropa GET /private **utan** token
- [ ] Förväntat: Får svar 401 Unauthorized

## 3. Public endpoint – GET /public
- [ ] Anropa GET /public utan token
- [ ] Förväntat: Får svar 200 OK alltid, oavsett login

## 4. POST /messages
- [ ] Försök skicka POST /messages **utan** token
- [ ] Förväntat: Får svar 401 Unauthorized
- [ ] Skicka POST /messages **med** token
- [ ] Förväntat: Meddelandet sparas, får svar 200 OK

## 5. OAuth2 Login
- [ ] Klicka "Login with GitHub" i frontend
- [ ] Logga in med GitHub-konto
- [ ] Anropa GET /private efter OAuth2-login
- [ ] Förväntat: Får svar 200 OK

## Vanliga fel att kolla
- JWT valideras inte → alla requests blockeras
- Glömt skriva `Bearer ` före token i headern
- Token har gått ut (giltig i 1 timme)
- OAuth2 redirect URI är fel