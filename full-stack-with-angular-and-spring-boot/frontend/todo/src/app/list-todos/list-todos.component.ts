import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) {

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {
  todos: Todo[];
  message: string;

  constructor(
    private todoService: TodoDataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.refreshTodos();
  }

  refreshTodos(): void {
    this.todoService.retrieveAllTodos('Ganesh').subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    );
  }

  deleteTodo(id): void {
    console.log(` delete todo ${id}`);
    this.todoService.deleteTodo('Ganesh', id).subscribe(
      response => {
        console.log(response);
        this.message = `Deleted todo ${id} for user Ganesh successfully.`;
        this.refreshTodos();
      }
    );
  }

  updateTodo(id): void {
    console.log(` update todo ${id}`);
    this.router.navigate(['todos', id]);
  }

  addTodo(): void {
    this.router.navigate(['todos', -1]);
  }

}
