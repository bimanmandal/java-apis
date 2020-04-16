### Item 10: Obey the general contract when overriding equals
* Each instance of the class is inherently unique
* There is no need for a class to provide a logically equality test
* A superclass has already overriddern equals, and the superclass behaviour is appropriate for the class
* The class is private or package private, and you are certain that its equals method will never bbe invoked.

