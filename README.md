# 🚌 Bus Service – Bus Reservation Management System

Bus Service is a backend microservice developed as part of a Bus Reservation Management System. This service handles route management, 
bus details, schedules, search functionality, and the complete booking flow with seat availability checks.

-----------------------------------------------------------------------------------------------------------

## 🚀 Features

- Route Management (Source & Destination)
- Bus Management mapped with routes
- Schedule Management (Travel date & time)
- Search buses by source, destination, and travel date
- Booking creation and confirmation
- Seat availability validation and overbooking prevention
- Global Exception Handling
- Clean API responses using DTOs

-----------------------------------------------------------------------------------------------------------

## 🛠️ Tech Stack

Java | Spring Boot | Spring Data JPA | REST APIs | MySQL | Maven | Git & GitHub

-----------------------------------------------------------------------------------------------------------

## 📂 Project Structure

bus-service  
controller | service | serviceImpl | repository | model | dto | exception | resources

-----------------------------------------------------------------------------------------------------------

## 🔗 Key APIs

- Add Route  
  `POST /routes`

- Add Bus with Route  
  `POST /buses/route/{routeId}`

- Add Schedule for Bus  
  `POST /schedules/bus/{busId}`

- Search Buses  
  `GET /schedules/search?source={source}&destination={destination}&travelDate={date}`

- Create Booking  
  `POST /bookings/schedule/{scheduleId}`

- Confirm Booking  
  `PUT /bookings/{bookingId}/confirm`

-----------------------------------------------------------------------------------------------------------

## ▶️ How to Run

1. Create MySQL database: `bus_db`  
2. Update database credentials in `application.properties`  
3. Run the Spring Boot application  
4. Test APIs using Postman  

-----------------------------------------------------------------------------------------------------------

## 🧠 Key Learnings

- Entity relationships (Route → Bus → Schedule → Booking)
- Real-world booking workflow implementation
- Seat availability and booking lifecycle handling
- DTO-based API design
- Centralized exception handling

-----------------------------------------------------------------------------------------------------------

## 👨‍💻 Author

Poovarasan M
