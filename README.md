# Railway Reservation Simulator model With Seat Booking GUI
> A simple Java Application which deals with railway reservation with emphesis on giving the user the freedom to choose any available seat rather than a random seat being alloted to them

<img src="images/pro.png" width=400>

---

### Table Of Contents
- [Description](#description)
- [License](#license)
- [How To Use](#how-to-use)
- [Author Info](#author-info)

---

## Description

The Fourth largest railway netork in the world, The Indian railway runs more than 20,000 passenger trains daily, on both long-distance and suburban routes, from 7,349 stations across India. This java based project simply allows a user to simulate the booking process with the added functionality of being specific about the seats( and coach) that the user desires. The user can also view his previous journies, cancel ticket, view the train chart, find a trains information, check pnr and can obviously create new accounts or delete previous accounts. All trains added have their original working days, number of coaches and seats.

### Technologies

- JAVA
- MySQL

<img src="images/findtrain.png" width=400>

<img src="images/gui.png" width=400>

---
## License
MIT License

Copyright (c) 2020 Gursimar Singh Bedi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

---

## How To Use
 ### Database
 The code for the database is in a notepad file, to be copied to MySQL.This reservation simulation model has 4 static tables: Users,Train,Station,Path. Although each time the first reservation for a perticular date is made a table is dynamically created for the chart information.
 ### Login
 Default login username=user password=pass or one can simply create a new account.
 ### Constraints
- The database has only few trains added to it.
- User has to search for stations using the station code. 
- No option for RAC/ Waiting List currently
- The user can book atmost 10 days in advance.

---

## Author Info
- Linkedin - [Gursimar Singh Bedi](https://www.linkedin.com/in/gursimar-singh-bedi-31439a170)

[Back to the top](#railway-reservation-simulator-model-with-seat-booking-gui)
