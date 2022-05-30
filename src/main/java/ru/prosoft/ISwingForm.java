package ru.prosoft;

/**
 * Интерфейс для реализации слабосвязанного взаимодействия между классами SwingForm и WellFundConverter
 * Описание взаимодействия:
 * 1) Класс SwingForm с элементами SWING-форм имплементирует интерфейс ISwingForm
 * 2) В классе SwingForm переопределяются метод, необходимые для обращения к элементам SWING:
 *
 * @Override public void textAreaAppend(String string) {
 * textArea.append(string + "\n");
 * }
 * 3) Запуск метода из внешнего обработчика, содержащегося в классе WellFundConverter осуществляется в классе SwingForm
 * private void runWellFundConverter() throws IOException {
 * wellFundConverter.runConverter(this);
 * }
 * 4) В классе WellFundConverter создается поле
 * private ISwingForm iSwingForm;
 * 5) В классе WellFundConverter метод runConverter определяется нижеследующим образом. При получении ISwingForm в качестве
 * параметра значение записывается в одноименное поле класса, после чего из любого метода можно обращаться к методам,
 * определенным в интерфейсе ISwingForm
 * public void runConverter(ISwingForm iSwingForm) throws IOException {
 * this.iSwingForm = iSwingForm;
 * ...
 * }
 */
public interface ISwingForm {

    /**
     * Метод textAreaAppend производит запись передаваемой строки в поле SWING-элемента textArea
     *
     * @param string
     */
    void textAreaAppend(String string);

    /**
     * Метод progressBarSetMin вызывает методы .setMinimum() и .setValue(0) для компонента JProgressBar
     * @param min
     */
    void progressBarSetMin(int min);

    /**
     * Метод progressBarSetMax вызывает метод .setMaximum() для компонента JProgressBar
     * @param max
     */
    void progressBarSetMax(int max);

    /**
     * Метод progressBarStep вызывает метод .setValue() для компонента JProgressBar
     * с инкрементным увеличением на один шаг
     */
    void progressBarStep();

}
