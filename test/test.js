const webdriver = require('selenium-webdriver')
const By = webdriver.By

const chai = require('chai')
const chai_as_promised = require('chai-as-promised')
chai.use(chai_as_promised)
const expect = chai.expect

const driver = new webdriver.Builder().forBrowser('chrome').build()

describe('hk01', () => {
  it('click channels', function() {
    driver.navigate().to('https://www.hk01.com/section/港聞/')
    const buttons = ['兩岸', '經濟', '環保', '罪案', '政情']
    for (let i = 0, len = buttons.length; i < len; i++) {
      driver.findElement(By.linkText(buttons[i])).click()
      expect(
        driver.findElement(By.className('current')).getText()
      ).to.eventually.eql(buttons[i])
    }

    return driver.findElement(By.linkText('主頁')).click()
  })

  it('click article', function() {
    driver
      .navigate()
      .to('https://www.hk01.com/港聞/79555/-一契多伙-避稅成風政府不修例-學者-現階段無計可施')
    expect(
      driver.findElement(By.className('article_tit')).getText()
    ).to.eventually.eql('「一契多伙」避稅成風政府不修例　學者：現階段無計可施')

    return driver.findElement(By.linkText('主頁')).click()
  })

  after(() => driver.quit())
})
