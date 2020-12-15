package subway.service;

import subway.constant.Constant;
import subway.constant.InitialData;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static subway.constant.Information.*;

public class LineService extends CrudService {

    public LineService(InputView inputView, OutputView outputView) {
        super(inputView, outputView, LINE_INFO);
        initLines();
    }

    private void initLines() {
        LineRepository.addLine(InitialData.lines);
    }


    @Override
    public void add() {
        Line newLine = getNewLine();
        validateNewLine(newLine);
        LineRepository.addLine(newLine);
        getOutputView().printInformation(ADD_LINE_SUCCESS);
    }

    private Line getNewLine() {
        String name = getNewLineName();
        List<Station> endStations = getNewLineEndStations();
        return new Line(name, endStations);
    }

    private String getNewLineName() {
        getOutputView().printInformation(ADD_LINE_INFO);
        return getInputView().getLineName();
    }

    private List<Station> getNewLineEndStations() {
        Station upEnd = getNewLineUpEnd();
        Station downEnd = getNewLineDownEnd();
        return new ArrayList<>(Arrays.asList(upEnd, downEnd));
    }

    private Station getNewLineUpEnd() {
        getOutputView().printInformation(ADD_LINE_INFO_UP_END);
        return new Station(getInputView().getStationName());
    }

    private Station getNewLineDownEnd() {
        getOutputView().printInformation(ADD_LINE_INFO_DOWN_END);
        return new Station(getInputView().getStationName());
    }

    private void validateNewLine(Line newLine) {
        validateNameLength(newLine);
        validateDuplicateLineExists(newLine);
        validateEndStationsExist(newLine);
    }

    private void validateNameLength(Line newLine) {
        if (newLine.getName().length() < Constant.MIN_NAME_LENGTH)
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_NAME_LENGTH);
    }

    private void validateDuplicateLineExists(Line newLine) {
        if (LineRepository.lines().contains(newLine))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.DUPLICATE_LINE);
    }

    private void validateEndStationsExist(Line newLine) {
        if (!StationRepository.stations().contains(newLine.getUpEnd())
                || !StationRepository.stations().contains(newLine.getDownEnd()))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_STATION);
    }


    @Override
    public void delete() {
        String targetLineName = getTargetLineName();
        validateTargetLine(targetLineName);
        LineRepository.deleteLineByName(targetLineName);
        getOutputView().printInformation(DELETE_LINE_SUCCESS);
    }

    private String getTargetLineName() {
        getOutputView().printInformation(DELETE_STATION_INFO);
        return getInputView().getLineName();
    }

    private void validateTargetLine(String targetLineName) {
        Line targetLine = new Line(targetLineName);
        if (!LineRepository.lines().contains(targetLine))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_LINE);
    }


    @Override
    public void show() {
        getOutputView().printLineList();
    }
}
