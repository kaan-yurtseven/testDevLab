@task
  Feature: Task
Scenario: Book cheapest 5* hotel in city
Given I am in "Booking.com | Official site | The best hotels, flights, car rentals & accommodations" page
When I set up destination as "Ankara"
And I set dates "2022-02-20" and "2022-02-23"
And I click on "Search" button