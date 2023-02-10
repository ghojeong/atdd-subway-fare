package dreamfora.subway.applicaion;

import dreamfora.subway.applicaion.dto.StationRequest;
import dreamfora.subway.applicaion.dto.StationResponse;
import dreamfora.subway.domain.Station;
import dreamfora.subway.domain.StationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Transactional
    public StationResponse saveStation(StationRequest stationRequest) {
        Station station = stationRepository.save(new Station(stationRequest.getName()));
        return StationResponse.of(station);
    }

    public List<StationResponse> findAllStations() {
        return stationRepository.findAll().stream().map(StationResponse::of).collect(Collectors.toList());
    }

    @Transactional
    public void deleteStationById(Long id) {
        stationRepository.deleteById(id);
    }

    public StationResponse createStationResponse(Station station) {
        return new StationResponse(station.getId(), station.getName());
    }

    public Station findById(Long id) {
        return stationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Station> findAllStationsById(Set<Long> stationIds) {
        return stationRepository.findAllById(stationIds);
    }
}