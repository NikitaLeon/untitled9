import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void matchesQuerySimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Boolean expected = true;
        Boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQuerySimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();
        todos.add(simpleTask);

        Boolean expected = false;
        Boolean actual = simpleTask.matches("подруге");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryMeetingTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Boolean expected = true;
        Boolean actual = meeting.matches("версии");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryMeetingFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        Boolean expected = false;
        Boolean actual = meeting.matches("Отладка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryEpicTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Boolean expected = true;
        Boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryEpicFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();
        todos.add(epic);

        Boolean expected = false;
        Boolean actual = epic.matches("Кефир");
        Assertions.assertEquals(expected, actual);
    }
}
