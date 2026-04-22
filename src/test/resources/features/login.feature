Feature: Navigating a pet store website and adding items to the cart

  Scenario:
    Given the user Open a web browser and navigate to the specified pet store URL
    And the user Click on the Enter the Store link to access the main page
    And the clicks Click on the Sign In link to log into the store
    When the user enters valid credentials (username: "j2ee", password: "j2ee")
    And the user Click on various product links to view details and add them to the cart
    Then the user Proceed to checkout after adding each product to the cart
    And the user Close the web browser after completing the actions
