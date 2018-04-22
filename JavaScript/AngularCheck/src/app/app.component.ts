import {Component} from '@angular/core';

@Component({
  selector: 'my-app'
  template: `<label>Input name</label>
            <input [(ngModel)]="name"/>
            <h2>Welcome,{{name}}</h2>`
})
export class AppComponent{
  name = ""

}
