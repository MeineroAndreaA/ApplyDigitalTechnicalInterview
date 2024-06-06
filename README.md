


# ApplyDigital LATAM

### Features

- List of news articles and comments fetched from the provided Algolia API (https://hn.algolia.com/api)

- Ability to delete a news article by swiping it.

- Offline mode handling. When the application is online and whenever the list is refreshed, it saves a copy of the news articles to a local Room database.

- Tapping on a news article opens a web view linking to the news article on the web.

- If the news article does not have a link, a Toast message will be displayed.

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

- Select a news item from the list and display it via web view. Additionally, show the title, author, and publication date.

https://github.com/MeineroAndreaA/ApplyDigitalTechnicalInterview/assets/42178965/15131e05-cc98-4acc-ad02-8cd3e53a2742

- Delete an item from the list with a swipe gesture.



https://github.com/MeineroAndreaA/ApplyDigitalTechnicalInterview/assets/42178965/72fde508-dffb-491d-817e-af66a1b3935b


- Refresh the list.


https://github.com/MeineroAndreaA/ApplyDigitalTechnicalInterview/assets/42178965/c97016ba-323c-46a9-a3f0-806155854239



- Persist the list locally even if there is no internet connection.

  

https://github.com/MeineroAndreaA/ApplyDigitalTechnicalInterview/assets/42178965/44b30c3e-0328-413a-b24e-bb8232192c24




- Delete items and retain the remaining items in the list even after it is refreshed.


https://github.com/MeineroAndreaA/ApplyDigitalTechnicalInterview/assets/42178965/4730bf2f-cb9d-4707-90ae-249869d45baa



## Installation

No special setup required for installation.
## Related

 3rd party libraries

- implementation (libs.threetenabp) https://github.com/JakeWharton/ThreeTenABP
- implementation (libs.swipe)  https://github.com/saket/swipe

