#Author: Luisa Fernanda Colorado

Feature: Search countries using multiples values
  As I user
  I want to search a country
  using a category, characteristic or name
  to get all details about it

Background: Open API countries
  Given The user open restCountries

Scenario: Search a country by name
  When wants to search a country by name
  Then should get all details about the country


