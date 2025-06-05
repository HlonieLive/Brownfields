
---

### **Project: User Authentication Manager**

**Overview:**
A basic user authentication system that stores usernames and passwords in memory. Passwords are stored in plain text, and all operations (registration, login, data handling) are in one class. There’s no security, no hashing, and no scalability.

---

**Key Issues to Refactor:**

* Plain-text password storage.
* No validation or error handling.
* Tight coupling of responsibilities.
* Hardcoded user data storage.
* No use of interfaces or services.

---

**Legacy Code Sample:**

```java
import java.util.*;

public class AuthManager {

    private Map users = new HashMap();

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("User already exists!");
            return;
        }
        users.put(username, password);
        System.out.println("User registered.");
    }

    public void login(String username, String password) {
        if (!users.containsKey(username)) {
            System.out.println("User not found!");
            return;
        }
        String storedPassword = (String) users.get(username);
        if (storedPassword.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect password.");
        }
    }
}
```

---

**Your Refactoring Goals:**

1. Introduce a `User` class.
2. Use secure password hashing (e.g., PBKDF2, bcrypt).
3. Separate concerns (auth logic, user storage, console I/O).
4. Add error handling and validation.
5. Make it easy to swap storage (in-memory, file, DB) using interfaces.

---
