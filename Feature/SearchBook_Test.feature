@featureTest
Feature: Amazon Book Search
Search for a book
Add the book to the cart

@Scenario1
Scenario: Search of Book
	Given a web browser is on the Amazon Home page
	When User searches for books in Category "Books" having  "javascript" Text.
	And the user clicks the first result link
	And Verify Product Title
	And Add Product To Cart
	Then Product Added To Cart
	And Titles verified Successfully
	

