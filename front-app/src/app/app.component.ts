import { Component } from '@angular/core';
import { CdkDragEnd } from "@angular/cdk/drag-drop";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-drag-drop';
  dragPosition = {x :661, y:313}

  dragEnd($event: CdkDragEnd) {
    console.log($event.source.getFreeDragPosition());
}
}
