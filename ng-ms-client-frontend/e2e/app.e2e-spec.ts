import { AngularMsClientExamplePage } from './app.po';

describe('angular-ms-client-example App', () => {
  let page: AngularMsClientExamplePage;

  beforeEach(() => {
    page = new AngularMsClientExamplePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
