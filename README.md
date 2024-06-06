


# ApplyDigital LATAM

### Features

- List of news articles and comments fetched from the provided Algolia API (https://hn.algolia.com/api)

- Ability to delete a news article by swiping it.

- Offline mode handling. When the application is online and whenever the list is refreshed, it saves a copy of the news articles to a local Room database.

- Tapping on a news article opens a web view linking to the news article on the web.

-If the news article does not have a link, a Toast message will be displayed.

## About the Project 

- MVVM Architecture
- Dependency injection with Hilt
- GSON for JSON parsing
- Retrofit for API calls
- Jetpack
    - Compose
    - Navigation

    

## API Reference

#### News List

```http
  GET https://hn.algolia.com/api/v1/search_by_date?query=mobile
```
## Demo



## Installation

No special setup required for installation.
## Related

 3rd party libraries

- [implementation (libs.threetenabp)](https://github.com/matiassingers/awesome-readme)
- [implementation (libs.threetenabp)](https://github.com/matiassingers/awesome-readme)

