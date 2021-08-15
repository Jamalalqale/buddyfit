# Buddyfit Tech Test
In this test, it is planned to create an app that has two fragments, one for showing a list of workout classes and another for showing details of each workout class. In listFragment, there should be a recyclerview for showing workout classes. By clicking on each item, it should be navigated to detailsFragment and shows title and description.

## Dependancies needed
- Add `navigation component` (https://developer.android.com/guide/navigation/navigation-getting-started)
- Add `retrofit` (https://square.github.io/retrofit/)
- Add `picasso` (https://github.com/square/picasso) or `glide` (https://github.com/bumptech/glide)

## Tasks
- Create two fragments (`listFragment` and `detailsFragment`)
- Add fragments to navigation graph
- Add ViewModels to fragments
- Add api call to retrieve list of classes `GET https://public-api.buddyfit.club/api/v1/classes`
- Create a model for `workout class` object with `name`, `description`, and `listPictureUrl` (ignore other data)
```json
    {
      "type": "classes",
      "_id": "string",
      "attributes": {
        "name": "string",
        "description": "string",
        "listPictureUrl": "string",
      }
    }
```
- Add a recyclerView in listFragment to show a list of classes (`GET https://public-api.buddyfit.club/api/v1/classes`)
- By click on each class, it should be navigated to details fragment and shows the class details (`name`, `description`, and `listPictureUrl`)

## Points
- Design is NOT important
- Try to code as much as clean possible

## Bonus
- Create Reusable view component for Class Item
- Add animation for fragment transition
- Init git and commit changes