package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;


    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {
        List<Route> mostCommented = routeRepository.findMostCommented();
        return mostCommented.get(0);
    }
}
