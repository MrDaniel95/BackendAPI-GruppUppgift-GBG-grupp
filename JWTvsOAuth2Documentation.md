# JWT vs OAuth2

---

## JWT - Ditt eget åkpass

När man går till Liseberg och köper sig ett åkpass i entrén så får man ett band runt 
handleden som är ens köpbevis. Då kan man fritt gå runt i parken och åka vilken
åkattraktion man vill, man behöver bara visa upp sitt åkpass-armband, personalen
vid åkattraktionerna behöver inte ringa till entrén för att dubbelkolla, utan du har
ju köpbeviset på dig.

Det är precis så som JWT fungerar, när man loggar in på en app så skickar du ditt
användarnamn och lösenord, sedan kollar servern att det stämmer och du får en 
**token(åkpasset)**.
Du bär med dig din token i varje förfrågan du skickar och servern kan direkt kika och
verifiera att den är giltig utan att behöva kolla databasen varje gång *(ringa entrén)*.

Om du mot förmodan skulle tappa bort ditt åkpass(token) och någon annan hittar det så 
kan de använda det tills att det går ut. Liseberg kan inte avaktivera ditt åkpass på
distans(i verkligheten så behöver man ju vara bra på att klippa och klistra ihop 
armbandet igen, det är mer en liknelse :-P).

**Men!** Samma sak gäller för JWT, om någon skulle få tag på din token så kan de
använda den tills den slutar gälla.

---

## OAuth2 - Guldpasset (inloggning via tredjepart)

Istället för att köpa ett nytt åkpass varje gång så kan man köpa sig ett Guldpass.
När du då kommer till Liseberg behöver du inte köpa ett nytt åkpass eller visa upp ett 
nytt köpbevis(lösenord), du visar istället bara upp ditt Guldpass och Liseberg vet 
direkt att du är verifierad och vad du har tillgång till!

Du godkänner att de får identifiera dig med hjälp utav ditt namn och bild från 
Guldpasset, du behöver inte ge dem något lösenord(betala i entrén) utan de känner
igen dig med hjälp av ditt Guldpass.

Det är precis så OAuth2 fungerar, men i verkligheten så är det GitHub eller Google som
är "Guldpasset", en pålitlig källa som appen litar på.
Du loggar in hos dem och de berättar för appen att du är verifierad och vilken
information appen får tillgång till, appen accepterar sedan det utan frågor, precis 
som Guldpasset på Liseberg.
---

## Jämförelsen

**JWT kan förklaras med Lisebergs liknelse såhär:**
- Liseberg trycker sina egna åkpass och behöver ingen hjälp utifrån, de är självständiga
och behöver ingen tredje parts hjälp för att trycka upp biljetter.

Alltså så passar JWT bra när:
- Din app sköter inloggningen helt själv utan någon hjälp från t.ex GitHub eller Google
- När du vill att det ska gå snabbt, servern behöver inte fråga databasen varje gång
- När du bygger t.ex ett API där användaren loggar in med användarnamn och lösenord

---

**OAuth2 kan förklaras med Lisebergs liknelse såhär:**
- Liseberg behöver inte trycka egna biljetter, de förlitar sig på att Guldpasset
redan bevisar vem du är.

Alltså så passar OAuth2 bra när:
- När du vill slippa behöva hantera lösenord helt själv, du lejer bort det ansvaret till
någon annan som sköter det.
- När du vill att användaren ska kunna logga in med ett redan befintligt konto, t.ex
GitHub eller Google.
- Eller när du bygger en app där du hellre vill förlita dig på en större aktör än din
egen säkerhet.

---

## Så vad är säkrast?

JWT och OAuth2 löser egentligen olika problem.
- OAuth2 är hur du får ditt pass och JWT är själva passet.
- Det används alltså ofta tillsammans, inte istället för varandra.

Det kan kännas som att det är säkrare att Liseberg trycker sina egna biljetter, då har
de mest koll, men om aktören som är tredjepart är väldigt bra och säkra så kan ju det
vara ett bättre alternativ.

**Guldpasset(OAuth2)** används oftare i större appar där man vill kunna erbjuda enkel
inloggning och slippa hantera känslig information som lösenord själv.
Det gör att utvecklaren kan fokusera mer på sin egen app istället för att bygga och 
underhålla ett helt inloggningssystem.

**Vanliga åkpasset(JWT)** passar bra när man vill ha lite mer kontroll och hantera allt
själv, t.ex i API:er eller mindre system där man redan har en egen inloggning.

- Men egentligen så handlar det inte om vilket som är säkrast, båda kan vara lika säkra.
- Det beror på HUR det används och implementeras i appen!

---