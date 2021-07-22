# LinkDev-Automation-Practice

The scenario to be automated: In the following dummy website: http://automationpractice.com/index.php • Create an account by filling the mandatory fields. • Login with the newly registered user • Through menu [Dresses], add some items to cart Hint: Every time you add an item to cart, assert that the message that appears in the popup window is updated “There are … items in your cart.” Also keep summing the item’s cost for later assertion. • Finally click Checkout • Assert that the amount displayed in “Total products” is correct.

The end to end scenario is in "TestCases/DressesMenuTest", Need to edit the email in the sheet every run time (Can't register the same email twice)
