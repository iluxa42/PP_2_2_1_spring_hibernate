package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Ivan", "Ivanov", "ivanov155@gmail.com");
      User user2 = new User("Petr", "Osipov", "osioetro777@mail.ru");
      User user3 = new User("Victor", "Lebedev", "vicleb555@gmail.com");
      User user4 = new User("Elena", "Smirnova", "smirnyash@yahoo.com");

      user1.setCar(new Car("BMW", 5));
      user2.setCar(new Car("Bugatti", 110));
      user3.setCar(new Car("Audi", 6));
      user4.setCar(new Car("Chrysler", 300));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      User userCar1 = userService.getUserByCar("Audi", 6);
      User userCar2 = userService.getUserByCar("Chrysler", 300);
      System.out.println();
      System.out.println(userCar1);
      System.out.println(userCar2);

      context.close();
   }
}
