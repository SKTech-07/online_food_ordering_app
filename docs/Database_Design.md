# Database Design

## Overview

The Online Food Ordering System uses a relational database designed to support user management, restaurant management, food menus, order processing, and customer reviews.

## Entities

- User
- Restaurant
- Food Item
- Order
- Order Item
- Review

## Relationships

- One User can own multiple Restaurants.
- One Restaurant offers multiple Food Items.
- One User can place multiple Orders.
- One Order contains multiple Order Items.
- One Food Item can belong to multiple Order Items.
- One User can write multiple Reviews.
- One Restaurant can receive multiple Reviews.

## Database Design

The database is normalized to reduce redundancy and maintain data integrity.