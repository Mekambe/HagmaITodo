package com.sda.todo.service;

import com.sda.todo.model.Todo;
import com.sda.todo.model.TodoUser;
import com.sda.todo.repository.TodoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class TodoServiceTest {

    @Test
    public void findTodosByCreatorNameShouldReturnTodosForExistingCreatorName() {
        //given
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        Mockito.when(todoRepository.findAll()).thenReturn(createSampleTodoList());

        TodoService todoService = new TodoService(todoRepository, null);

        //when
        List<Todo> todos = todoService.findTodosByCreatorName("admin");

        //then
        Assert.assertEquals(2, todos.size());
        todos.forEach(todo -> {
            Assert.assertEquals("admin", todo.getCreator().getName());
        });

    }

    @Test
    public void findTodosByCreatorNameShouldReturnEmptyListForNonExisitngCreatorName() {
        //given
        TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
        Mockito.when(todoRepository.findAll()).thenReturn(createSampleTodoList());

        TodoService todoService = new TodoService(todoRepository, null);

        //when
        List<Todo> todos = todoService.findTodosByCreatorName("non-existing");

        //then
        Assert.assertEquals(0, todos.size());
    }

    private List<Todo> createSampleTodoList() {
        TodoUser todoUser = new TodoUser("admin", "admin");
        TodoUser todoUser2 = new TodoUser("user-1", "password");
        TodoUser todoUser3 = new TodoUser("user-2", "ala ma kota");

        Todo todo1 = new Todo("Zrobic zakupy", todoUser);
        Todo todo2 = new Todo("Ugotowac obiad", todoUser);
        Todo todo3 = new Todo("Przeczytac ksiazke", todoUser2);
        Todo todo4 = new Todo("Poszukac kluczy", todoUser3);

        return Arrays.asList(todo1, todo2, todo3, todo4);
    }

}
