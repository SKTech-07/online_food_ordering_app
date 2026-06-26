# Relational Database Schema

## Overview

This document describes the relational database schema for the **Online Food Ordering System**. The schema is designed based on the finalized Entity Relationship (ER) Diagram and follows normalization principles to ensure data integrity and reduce redundancy.

---

# USER

| Column | Data Type | Constraints |
|----------|-----------|-------------|
| user_id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | NOT NULL |
| email | VARCHAR(100) | UNIQUE, NOT NULL |
| phone_number | VARCHAR(15) | NOT NULL |
| password | VARCHAR(255) | NOT NULL |
| address | VARCHAR(255) | NOT NULL |
| role | ENUM('CUSTOMER','OWNER','ADMIN') | NOT NULL |

---

# RESTAURANT

| Column | Data Type | Constraints |
|----------|-----------|-------------|
| restaurant_id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | NOT NULL |
| address | VARCHAR(255) | NOT NULL |
| phone_number | VARCHAR(15) | NOT NULL |
| description | TEXT | |
| owner_id | BIGINT | Foreign Key → USER(user_id) |

---

# FOOD_ITEM

| Column | Data Type | Constraints |
|----------|-----------|-------------|
| food_id | BIGINT | Primary Key, Auto Increment |
| name | VARCHAR(100) | NOT NULL |
| price | DECIMAL(10,2) | NOT NULL |
| category | VARCHAR(50) | NOT NULL |
| availability | BOOLEAN | DEFAULT TRUE |
| image_url | VARCHAR(255) | |
| restaurant_id | BIGINT | Foreign Key → RESTAURANT(restaurant_id) |

---

# ORDERS

| Column | Data Type | Constraints |
|----------|-----------|-------------|
| order_id | BIGINT | Primary Key, Auto Increment |
| order_date | DATETIME | NOT NULL |
| total_amount | DECIMAL(10,2) | NOT NULL |
| status | VARCHAR(30) | NOT NULL |
| payment_method | VARCHAR(30) | DEFAULT 'Cash on Delivery' |
| delivery_address | VARCHAR(255) | NOT NULL |
| user_id | BIGINT | Foreign Key → USER(user_id) |
| restaurant_id | BIGINT | Foreign Key → RESTAURANT(restaurant_id) |

---

# ORDER_ITEM

| Column | Data Type | Constraints |
|----------|-----------|-------------|
| order_item_id | BIGINT | Primary Key, Auto Increment |
| quantity | INT | NOT NULL |
| price | DECIMAL(10,2) | NOT NULL |
| order_id | BIGINT | Foreign Key → ORDERS(order_id) |
| food_id | BIGINT | Foreign Key → FOOD_ITEM(food_id) |

---

# REVIEW

| Column | Data Type | Constraints |
|----------|-----------|-------------|
| review_id | BIGINT | Primary Key, Auto Increment |
| rating | INT | NOT NULL |
| comment | TEXT | |
| review_date | DATETIME | NOT NULL |
| user_id | BIGINT | Foreign Key → USER(user_id) |
| restaurant_id | BIGINT | Foreign Key → RESTAURANT(restaurant_id) |

---

# Relationships

- One User can own many Restaurants.
- One Restaurant can offer many Food Items.
- One User can place many Orders.
- One Restaurant can receive many Orders.
- One Order can contain many Order Items.
- One Food Item can appear in many Order Items.
- One User can write many Reviews.
- One Restaurant can receive many Reviews.

---

# Database Summary

| Entity | Primary Key |
|----------|-------------|
| USER | user_id |
| RESTAURANT | restaurant_id |
| FOOD_ITEM | food_id |
| ORDERS | order_id |
| ORDER_ITEM | order_item_id |
| REVIEW | review_id |

---

## Normalization

The database schema is designed following **Third Normal Form (3NF)** to:

- Eliminate redundant data.
- Ensure referential integrity.
- Maintain consistency between related tables.
- Improve scalability and maintainability.
