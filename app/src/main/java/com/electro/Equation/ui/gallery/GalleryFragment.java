package com.electro.Equation.ui.gallery;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.electro.Equation.R;

public class GalleryFragment extends Fragment {

    //private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final TextView textView = root.findViewById(R.id.rules);

        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.setText(Html.fromHtml("" +
                "<h1>Понятие квадратного уравнения</h1>\n" +
                "<p><strong>Уравнения</strong> — это математическое равенство, в котором неизвестна одна или несколько величин. Значения неизвестных нужно найти так, чтобы при их подстановке в пример получилось верное числовое равенство.</p>\n" +
                "<p>Например, возьмем выражение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">3 + 4 = 7</span>. При вычислении левой части получается верное числовое равенство, то есть <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">7 = 7</span>.</p>\n" +
                "<p>Уравнением можно назвать выражение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">3 + x = 7</span>, с неизвестной переменной <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x</span>, значение которой нужно найти. Результат должен быть таким, чтобы знак равенства был оправдан, и левая часть равнялась правой.</p>\n" +
                "<p><strong>Степень уравнения</strong> можно определить по наибольшей степени, в которой стоит неизвестное. Если неизвестное стоит во второй степени — это квадратное уравнение.</p>\n" +
                "<p><strong>Квадратное уравнение</strong> — это уравнение вида <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">ax² + bx + c = 0</span>, где <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">a</span> — первый или старший коэффициент, не равный нулю, <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">b</span> — второй коэффициент, <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">c</span> — свободный член.</p>\n" +
                "<p><strong>Есть три вида квадратных уравнений:</strong></p>\n" +
                "<ul>\n" +
                "<li> Не имеющие корней;</li>\n" +
                "<li> Имеющие один корень;</li>\n" +
                "<li> Имеющие два различных корня.</li>\n" +
                "</ul>\n" +
                "<p>Чтобы определить, сколько корней имеет уравнение, нужно обратить внимание на <strong>дискриминант</strong>. Чтобы его найти, берем формулу: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">D = b² − 4ac</span>. Если:</p>\n" +
                "<ul>\n" +
                "<li> <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">D &lt; 0</span>, то корней нет;</li>\n" +
                "<li> <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">D = 0</span>, то есть один корень;</li>\n" +
                "<li> <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">D &gt; 0</span>, то есть два различных корня.</li>\n" +
                "</ul>\n" +
                "<h1>Приведенные и неприведенные квадратные уравнения</h1>\n" +
                "<p>Квадратное уравнение может быть <strong>приведенным</strong> или <strong>неприведенным</strong> — все зависит от значения первого коэффициента.</p>\n" +
                "<p><strong>Приведенное квадратное уравнение</strong> — это уравнение, где старший коэффициент, тот который стоит при одночлене высшей степени, равен единице.</p>\n" +
                "<p><strong>Неприведенным</strong> называют квадратное уравнение, где старший коэффициент может быть любым.</p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x² — 2x + 6 = 0</span></p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x² — x — 1/4 = 0</span></p>\n" +
                "<p>В каждом из них старший коэффициент равен единице (которую мы мысленно представляем при <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x²</span> ), а значит уравнение называется приведенным.</p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">2x² − 4x — 12 = 0</span> — первый коэффициент отличен от единицы (<span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">2</span>), значит это неприведенное квадратное уравнение.</p>\n" +
                "<p>Каждое неприведенное квадратное уравнение можно преобразовать в приведенное, если произвести <strong>равносильное преобразование</strong> — разделить обе его части на первый коэффициент.</p>\n" +
                "<p><em>У преобразованного уравнения те же корни, что и у первоначального. Ну или вообще нет корней.</em></p>\n" +
                "<h1>Полные и неполные квадратные уравнения</h1>\n" +
                "<p>В определении квадратного уравнения есть условие: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">a ≠ 0</span>. Оно нужно, чтобы уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">ax² + bx + c = 0</span> было именно квадратным. Если <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">a = 0</span>, то уравнение обретет вид линейного: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">bx + c = 0</span>.</p>\n" +
                "<p>Что касается коэффициентов <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">b</span> и <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">c</span>, то они могут быть равны нулю, как по отдельности, так и вместе. В таком случае квадратное уравнение принято назвать неполным.</p>\n" +
                "<p><strong>Неполное квадратное уравнение</strong> — это квадратное уравнение вида <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">ax² + bx + c = 0</span>, где оба или хотя бы один из коэффициентов b и c равен нулю.</p>\n" +
                "<p><strong>Полное квадратное уравнение</strong> — это уравнение, у которого все коэффициенты отличны от нуля.</p>\n" +
                "<h1>Решение квадратных уравнений</h1>\n" +
                "<h2>Полные квадратные уравнения</h2>\n" +
                "<ul>\n" +
                "<li> <b>Вариант 1:</b></li>\n" +
                "</ul>\n" +
                "<p>Для примера возьмём уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">−4x² + 28x - 49 = 0</span></p>\n" +
                "<p>Находим дискриминант: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">D = b² - 4ac = 28² — 4*(-4)*(-49) = 784 — 784 = 0</span></p>\n" +
                "<p>Если дискриминант больше <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span>, то корни вычисляем по этой формуле <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = ( -b - √D ) / ( 2 * a ) </span>;</p>\n" +
                "<p>Если дискриминант равен <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span> (наш случай), то корни вычисляем по этой формуле: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">х = -b/2a</span> (<span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">х = -28/(2*(-4)) = 3,5</span>)</p>\n" +
                "<p>Если дискриминант меньше <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span>, то уравнение не имеет корней!</p>\n" +
                "<ul>\n" +
                "<li> <b>Вариант 2:</b></li>\n" +
                "</ul>\n" +
                "<p>Если второй множитель является чётным, то можно воспользоваться упрощённым способом решения.</p>\n" +
                "<p>Для примера возьмём уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">−x² + 2x + 8 = 0</span></p>\n" +
                "<p>Находим сокращённый дискриминант: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">D₁ = k² - ac = 1² — (-1)*8 = 1 + 8 = 9</span>, где <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">k=b/2</span></p>\n" +
                "<p>Если дискриминант больше <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span> (наш случай), то корни вычисляем по этой формуле <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = ( -k - √D₁ ) / a </span>;</p>\n" +
                "<p>Если дискриминант равен <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span>, то корни вычисляем по этой формуле: <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">х = -k/a</span></p>\n" +
                "<p>Если дискриминант меньше <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span>, то уравнение не имеет корней!</p>\n" +
                "<ul>\n" +
                "<li> <b>Вариант 3:</b></li>\n" +
                "</ul>\n" +
                "<p><strong>Теорема Виета</strong></p>\n" +
                "<blockquote>\n" +
                "<p>Сумма корней x2 + bx + c = 0 равна второму коэффициенту с противоположным знаком, а произведение корней равняется свободному члену.</p>\n" +
                "</blockquote>\n" +
                "<p>Для примера возьмём уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">−x² + 4x + 3 = 0</span></p>\n" +
                "<p>В соответствии с теоремой можно записать:</p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x₁ + x₂ = -4</span></p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x₁ * x₂ = 3</span></p>\n" +
                "<p>Далее перебираем возможные корни. В данном случае идеально подходят -1 и -3.</p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">-1 + (-3) = -4</span></p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">-1 * (-3) = 3</span></p>\n" +
                "<h2>Не полные квадратные уравнения</h2>\n" +
                "<ul>\n" +
                "<li> <strong>Случай 1</strong> <em>есть только первый и второй множитель</em></li>\n" +
                "</ul>\n" +
                "<p>Для примера возьмём уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0,5x² + 0,125x = 0</span></p>\n" +
                "<p>Выносим <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x</span> за скобки (<span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x (0,5x + 0,125) = 0</span>)</p>\n" +
                "<p>Есть правило:</p>\n" +
                "<blockquote>\n" +
                "<p>Произведение равно 0 только в том случае, если хотя бы один из его множителей равен 0.</p>\n" +
                "</blockquote>\n" +
                "<p>Таким образом получается, что или <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = 0</span>, или <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0,5x + 0,125 = 0 =&gt; x = -0,25</span></p>\n" +
                "<p>Итак, <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = 0</span> и <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = -0,25</span></p>\n" +
                "<ul>\n" +
                "<li> <strong>Случай 2</strong> <em>есть только первый и третий множитель</em></li>\n" +
                "</ul>\n" +
                "<p>Для примера возьмём уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">4x² - 16 = 0</span></p>\n" +
                "<p>Переносим <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">-16</span> на другую сторону, получая <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">4x² = 16 =&gt; x² = 4</span></p>\n" +
                "<p>Если с правой стороны стоит число меньше <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">0</span>, то уравнение решений не имеет.</p>\n" +
                "<p>Иначе же из обоих частей вычисляем корень, получая <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = 2</span></p>\n" +
                "<p>Итак, <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = 2</span></p>\n" +
                "<ul>\n" +
                "<li> <strong>Случай 3</strong> <em>есть только первый множитель</em></li>\n" +
                "</ul>\n" +
                "<p>Для примера возьмём уравнение <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">ax² = 0</span>, где <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">a</span>, любое число, отличное от нуля.</p>\n" +
                "<p><span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">ax² = 0 =&gt; x² = 0/a =&gt; x² = 0 =&gt; x = 0</span></p>\n" +
                "<p>Итак, <span style=\"padding: .2em .3em;background-color: #ffffff;border-radius: 4px;\">x = 0</span></p>\n" +
                "<p><strong>Удачи в решении квадратных уравнений!</strong></p>\n"// +
        ));
        return root;
    }
}