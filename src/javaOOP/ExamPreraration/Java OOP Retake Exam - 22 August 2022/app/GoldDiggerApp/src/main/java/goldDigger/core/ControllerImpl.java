package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Arrays;


import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.DISCOVERER_DOES_NOT_EXIST;
import static goldDigger.common.ExceptionMessages.DISCOVERER_INVALID_KIND;

public class ControllerImpl implements Controller{
    DiscovererRepository discovererRepository = new DiscovererRepository();
    SpotRepository spotRepository = new SpotRepository();
    public ControllerImpl() {
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;
        switch (kind) {
            case "Archaeologist" :
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist" :
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist" :
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        SpotImpl spot = new SpotImpl(spotName);
        spot.setExhibits(Arrays.asList(exhibits));
        spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(DISCOVERER_DOES_NOT_EXIST);
        }
        discovererRepository.remove(discoverer);

        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Discoverer suitableDiscoverer;
        double discovererEnergy = 0;
        Spot inspectedSpot = spotRepository.byName(spotName);
        for (Discoverer discoverer : discovererRepository.getCollection()) {
            if (discoverer.getEnergy() > 45) {
                return String.format(INSPECT_SPOT, spotName);
            }
        }

        return null;
    }

    @Override
    public String getStatistics() {
        return null;
    }
}
