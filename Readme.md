# Kotlin Restful
## Table of Contents
1. [General Info](#general-info)
2. [Data Model](#data-model)
2. [Appearance](#appearance)
3. [Documentation](#docs)
4. [Made with](#technologies)
### General Info
***
A very simple booking management for my hotel in Gran Canaria. \
Is under construction but I put all my energy into it.

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

### Docs
* [Documentation PDF](https://github.com/TeteV/hotelDocs/blob/master/docs/Documentacion.pdf) (Spanish)


## Made with
[Android Studio](https://developer.android.com/studio) Website.

[Adobe XD](https://www.adobe.com/es/products/xd.html)

Readme.md template by [Villanuevand](https://gist.github.com/Villanuevand/6386899f70346d4580c723232524d35a)

---
💻 with 💜 by [TeteV](https://github.com/TeteV) 🐦
