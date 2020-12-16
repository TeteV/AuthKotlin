# Kotlin Restful
## Table of Contents
1. [General Info](#general-info)
2. [Data Model](#data-model)
3. [Appearance](#appearance)
4. [Usability](#usability)
5. [Documentation](#docs)
6. [Made with](#technologies)
### General Info
***
A very simple booking management for my hotel in Gran Canaria. \
Is under construction but I put all my energy into it.

This proyect can run with my backend here: \
[Backend](https://github.com/TeteV/CRUDLumen)

## Data Model

In database have the following tables, \
Users Have: Id, Dni, Name (Complete), email, password(codified), api_token, url_img(Thumbnail)
Rooms Have: num (Room Number), num_ppl (Numbers of people can stay), size, avaible,url_img(Photos of the room), user_Id(FK)\
Booking Have: Check-in, Check-out, Diet, num_room(FK), user_id(FK)

### RelationShips
A user can only book a room that's available
A user can book  many rooms

A room only can book to one User

### E/R Diagram
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/eR.JPG)

### Relational Model
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/relational.JPG)

### Use Case
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/CassoUso.jfif)

A non Reg Person can only see the available rooms.
A registered person can see available rooms and book it.

## Appearance
***
There's the login windows, you can log with Facebook/Google Auth or with a basic auth with user and password
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/log-wind.JPG)

***
Here's Sign-in and Sign-up window so simple\
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/sign-in.JPG)
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/sign-up.JPG)
***

There's all the rooms avaible in the hotel, and when you click in your favorite room you see some look like that\
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/search.JPG)
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/searchead.JPG)

***
Here the details of the room: photos and a form where you check/put your info.\
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/deatils.JPG)

***
Here your user details to change/delete your account things\
![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/user-deatils.JPG)
### Usability
##### First of all
You must to create your user in Sig-In window.

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/signinchustra.JPG)

Then you can login in Log-In window and you see something like this

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/succlog.JPG)

Then you can insert your preferences, in this case I will go alone

This is the list of all rooms and you can take your favourite, with images
though is an iguana, I like this room.

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/iguana.JPG)

I pick this iguana's room and it show me the diet I want and the details of the room and the book button to rent and have a nice weekend

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/fullpen.JPG)

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/confirm.JPG)

##### Change user info
You can delete or change your user info, clicking un the user button top right of the app \
and show your info

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/userinfo.JPG)

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/userinfomysql.JPG)

Make some changes

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/userinfoupdate.JPG)

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/userinfoupdatemysql.JPG)

And last , you can delete your account

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/deleteuser.JPG)

And the code for delete a user in backend

![Image text](https://github.com/TeteV/AuthKotlin/blob/master/img/deleteusercode.JPG)

### Docs
* [Documentation PDF](https://github.com/TeteV/hotelDocs/blob/master/docs/Documentacion.pdf) (Spanish)

### Why Kotlin?
***
Kotlin is a new modern language based in Java. Developed by JetBrains 

This formal language is statically typed and can be used on servers, on websites and in the Apple operating system (iOS)

Enables mixed projects by mixing Java code with Kotlin code.


Fundamentally it has object-oriented constructions also allows simple and more complex function constructions and can mix elements of both styles

In android studio you can check your proyect in differents Hosts 

##### Advantage
* Coding in Kotlin is very short, concise, and straightforward. Same work with fewer lines of code than in Java
* Higher order functions, are those that take a function as an argument and return type
* Backed by JetBrains, Google, and Spring Framework

##### Disadvantages
* Longer execution time
* The code becomes a bit difficult to read and understand at first
* Small Support Community


## Technology Compration

| Comparative | PWA | Web apps |  Hybrid | Native |
| ------------- | ------------- |------------- |------------- | ------------- |
| Costs  | Cheap | Cheaper | Expensive than WA  | More expensive  |
| Exports code | Can run in every host |Can run in every host | Can run in most of hosts  | Only for native platform |
| Develop Time | Short |Short  | Medium  | Large  |
| Hardware Usage | Partial |Partial  | Take advantage of some hardware | Full advantage of the hardware  |
| Maintenance  | Easy | Easy  | Medium  | Complex  |
| Offline Usage  | Can run offline if you navigated it |Always connect to internet  | Always connect to internet  | Can run offline  |
| Security  | Normal | Normal  | Normal  | High  |
| Notifications  | Push Notif |No  | Yes  | Push Notif  |
| Storage  | No, but you can have an icon in desktop |No  | Yes  | Yes  |
| AppStore  | Yes | No  | Yes  | Yes  |

## Made with
[Android Studio](https://developer.android.com/studio) Website.

****
💻 with 💜 by [TeteV](https://github.com/TeteV) 🐦
