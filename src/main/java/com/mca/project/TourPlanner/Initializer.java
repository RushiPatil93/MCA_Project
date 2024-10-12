package com.mca.project.TourPlanner;

import com.mca.project.TourPlanner.model.Event;
import com.mca.project.TourPlanner.model.Group;
import com.mca.project.TourPlanner.model.GroupRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Kaas plateau", "Mahabaleshwar", "Andharban Trek",
                "Kundalika Valley").forEach(name ->
                repository.save(new Group(name))
        );
//        Stream.of("Kaas Pathar Satara Maharastra","Mahabaleshwar Satara",
//                "Andharban Pimpri pune","Kundalika Valley Pune").forEach(address ->
//                repository.save(new Group(address))
//        );

        //////
        Group tour1 = repository.findByName("Kaas plateau");
        tour1.setAddress("Kaas Pathar, Satara, Maharashtra");
        repository.save(tour1); // Save the group with updated address

        // Assign address for "Mahabaleshwar"
        Group tour2 = repository.findByName("Mahabaleshwar");
        tour2.setAddress("Mahabaleshwar, Satara, Maharashtra");
        repository.save(tour2); // Save the group with updated address

        // Assign address for "Andharban Trek"
        Group tour3 = repository.findByName("Andharban Trek");
        tour3.setAddress("Andharban, Pimpri, Pune");
        repository.save(tour3); // Save the group with updated address

        // Assign address for "Kundalika Valley"
        Group tour4 = repository.findByName("Kundalika Valley");
        tour4.setAddress("Kundalika Valley, Pune");
        repository.save(tour4); // Save the group with updated address

        ///
        Event e1 = Event.builder().title("One night stay and food accommodation added.")
                .description("Hurry up! Few seats are remaining.")
                .date(Instant.parse("2024-10-13T17:00:00.000Z"))
                .build();
        tour1.setEvents(Collections.singleton(e1));
        repository.save(tour1);

        Event e2 = Event.builder().title("Three night stay and food accommodation added.")
                .description("Hurry up! Few seats are remaining.")
                .date(Instant.parse("2024-10-17T17:00:00.000Z"))
                .build();
        tour2.setEvents(Collections.singleton(e2));
        repository.save(tour2);

        Event e3 = Event.builder().title("One night stay and food accommodation added.")
                .description("Hurry up! Few seats are remaining.")
                .date(Instant.parse("2024-10-21T17:00:00.000Z"))
                .build();
        tour3.setEvents(Collections.singleton(e3));
        repository.save(tour3);

        Event e4 = Event.builder().title("One night stay and food accommodation added.")
                .description("Hurry up! Few seats are remaining.")
                .date(Instant.parse("2024-10-28T17:00:00.000Z"))
                .build();
        tour4.setEvents(Collections.singleton(e4));
        repository.save(tour4);

        repository.findAll().forEach(System.out::println);
    }
}
