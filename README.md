
<h3 align="center">Bank REST API</h3>

  <p align="center">
    A bank RESTful API to handle typical request from customer, workers and third-parties.
  </p>




<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

The objective of the project is to crete the structure and routes for the different requirements.
Also, providing authntication and authorization on a basic level, to restrict who can do what in the app.

### Built With

* [Spring](https://spring.io/)
* [Java](https://www.java.com/en/)
* [Maven](https://maven.apache.org/)
* [Lombok](https://projectlombok.org/)
* [MySQL](https://www.mysql.com/)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

This a list of minimum requirements to run the program:

* [Java SE 11](https://www.oracle.com/java/technologies/javase-downloads.html)
* [MySQL Workbench 8.0 CE](https://dev.mysql.com/downloads/workbench/)

Be sure to:
1. Assign valid values in properties `spring.data.source`, `spring.data.username` and `spring.data.password`
   in `application.properties`.


### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/EN-IH-WDPT-JUN21/Gustavo_Maldonado_midterm_project.git
   ```


<!-- USAGE EXAMPLES -->
## Usage

### Start
1. Open the project on your IDE.
2. Go to the BankApiApplication class in the `src` directory.
3. Run the main method.
4. Create a user through MySQL.
5. Create the 'SUPER_USER' role and assign it to that user.

### SUPER_USER
1. Only one with the authority to create ADMIN users.

### ADMIN
1. Only users that can create new clients and new accounts.



### Next steps
* Missing some functionality, like third party users.
* Add more testing.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Gustavo Maldonado - [@GustavoM01](https://github.com/GustavoM01)

Project Link: [https://github.com/EN-IH-WDPT-JUN21/Gustavo_Maldonado_midterm_project.git](https://github.com/EN-IH-WDPT-JUN21/Gustavo_Maldonado_midterm_project.git)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Ironhack Team](https://www.ironhack.com/es)