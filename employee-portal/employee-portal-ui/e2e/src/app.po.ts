import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(url: string): Promise<any> {
    return browser.get(browser.baseUrl + url) as Promise<any>;
  }

  getTitleText(selector: string): Promise<string> {
    return element(by.css(selector)).getText() as Promise<string>;
  }
}
