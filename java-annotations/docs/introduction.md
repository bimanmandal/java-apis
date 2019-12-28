## Annotations

### What is Annotation?
>Annotations, a form of metadata, provide data about a program that is not part of the program itself. 
>Annotations have no direct effect on the operation of the code they annotate.

### Annotations use
1. Annotations can be used by the compiler to detect errors or suppress warnings.
2. Software tools can process annotation information to generate code, XML files, and so forth.
3. Some annotations are available to be examined at runtime.


### Different Format of Annotation
```java
@Entity
@Author(name = "Biman", place = "Bangalore")
@Author("Biman") // if one element then name can be omitted
```

*It is also possible to declare multiple annotations*
```java
@Book
@Author(name = "Biman Mandal")
class MyBook { ... }
```

***Repeating Annotation:** Annotation having same type*
```java
@Author(name = "Biman Mandal")
@Author(name = "Samik Bandopadhyay")
class MyBook { ... }
```
### Where annotations can be used
Annotations can be used infornt of 
1. Class
2. Fields
3. Methods
4. Interface
5. Types

### Predefined Annotations
#### Annotations used by Java
```java
1. @Deprecated
2. @Override
3. @SuppressWarnings("...")
4. @SafeVarargs
5. @FunctionalInterface
```
#### Annotations that apply on other annotations
```java
1. @Retention
2. @Documented
3. @Target 
4. @Inherited 
5. @Repeatable 
```

