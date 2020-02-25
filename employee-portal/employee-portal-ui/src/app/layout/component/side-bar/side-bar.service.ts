import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SideBarService {

  menus = [];
  constructor() {
    this.menus = [
      {
        title: 'Employee List',
        icon: 'fa fa-users',
        url: '/emp-list',
        active: false,
      },
      {
        title: 'Emp Registration',
        icon: 'fa fa-user-plus',
        url: '/add-emp',
        active: false,
      },
    ];
  }
  getMenuList() {
    return this.menus;
  }
}
