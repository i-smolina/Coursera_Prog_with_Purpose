import matplotlib.pyplot as pyplot

# sample execution: python3 barchart.py

# color palette from https://vega.github.io/vega/docs/schemes/
# (replaced #d62728 with #d64c4c)
hex20 = ['#aec7e8', '#c5b0d5', '#c49c94', '#dbdb8d', '#17becf',
         '#9edae5', '#f7b6d2', '#c7c7c7", '#1f77b4', '#ff7f0e',
         '#ffbb78', '#98df8a', '#d64c4c", '#2ca02c', '#9467bd',
         '#8c564b', '#ff9896', '#e377c2', '#7f7f7f', '#bcbd22']

class BarChart:
    """
    A class used to draw a bar chart in a window.
    It supports adding a bar (with a specified name, value, and category)
    and drawing all of the bars in a windows.
    The bars are drawn horizontally (in the order in which they are added,
    from top to bottom) and colored according to the category.
    The name and value of the bar and drawn with the bar.

    Requires Python 3 and matplotlib.
    To install matplotlib, type "python3 -m pip install -U matplotlib"

    Methods
    -------
    add(name, value, category)
        Adds a bar to the bar chart

    draw()
        Draws the bar chart

    reset()
        Removes all bars from the bar chart

    set_caption(caption)
        Sets the caption of the bar chart

    save(filename)
        Save the barchart as a PNG, JPEG, or PDF file

    leave_window_open()
        Leave the window open until the user closes it
    """


    def __init__(self, title, x_axis_label, data_source):
        """
        Parameters
        -----------
        title : str
            The title of the bar chart
        x_axis_label : str
            The label of the x-axis of the bar chart
        data_source : str
            The source of the underlying data
        """

        self.title = title
        self.x_axis_label = x_axis_label
        self.data_source = data_source
        self.color_of = { }
        self.reset()

        # remove toolbar at bottom of graphics window
        pyplot.rcParams['toolbar'] = 'None'
        self.fig = pyplot.figure(figsize=(10, 7), num=title)
        self.fig.show()

    def set_caption(self, caption):
        """
        Sets the caption of the bar chart.

        Parameters
        -----------
        caption : str
            The caption of the bar chart
        """

        self.caption = caption

    def reset(self):
        """
        Removes all of the bars from the bar chart.
        This method is useful for creating an animated bar chart.
        """

        self.colors = []
        self.values = []
        self.names = []
        self.caption = ''

    def add(self, name, value, category):
        """Adds a bar to the bar chart.

        Parameters
        -----------
        name : str
            The name of the bar
        value : int
            The value of the bar
        category : str
            The category of the bar (used to color the bar)
        """

        if category not in self.color_of:
            self.color_of[category] = hex20[len(self.color_of) % len(hex20)]
        self.names.append(name)
        self.values.append(value)
        self.colors.append(self.color_of[category])

    def leave_window_open(self):
        """Leave the window containing the bar chart open.
           This should be the last barchart function call.
        """
        pyplot.show()

    def save(self, filename):
        """Saves the bar chart as a PNG, JPEG, or PDF file.

        Parameters
        -----------
        filename : str
            The name of a PNG, JPEG, or PDF file
        """
        pyplot.savefig(filename)

    def draw(self):
        k = len(self.names)
        y_pos = list(reversed(range(k)))
        max_value = max(self.values)

        # clear the figure
        pyplot.clf()


        # remove box around figure
        pyplot.gca().spines['top'].set_visible(False)
        pyplot.gca().spines['bottom'].set_visible(False)
        pyplot.gca().spines['left'].set_visible(False)
        pyplot.gca().spines['right'].set_visible(False)
        pyplot.gca().tick_params(axis='x',
                                 labelcolor='#808080',
                                 labelsize=8,
                                 labeltop=True,
                                 labelbottom=False)
        pyplot.gca().xaxis.set_label_position('top')

        pyplot.xlabel(self.x_axis_label, fontsize=9, color='#808080', labelpad=10, x=0, horizontalalignment='left')

        # suppress y-axis label and tick values
        pyplot.ylabel('')
        pyplot.yticks([])

        pyplot.subplots_adjust(left=0.01, right=0.90, top=0.8, bottom=0.0)
        pyplot.suptitle(self.title, y=0.95, fontweight='bold', fontsize=16)
        pyplot.barh(y_pos, self.values, align='center', color=self.colors, zorder=3)
        pyplot.grid(b=True, which='major', axis='x', color='#E6E6E6', linewidth=0.5)

        # write caption
        if len(self.caption) <= 4:
            font_size = '48'
        elif len(self.caption) <= 8:
            font_size = '24'
        else:
            font_size = '14'
        pyplot.text(1.1*max_value,
                    0.15 * k,
                    self.caption,
                    fontsize=font_size,
                    fontweight='bold',
                    color='#BBBBBB',
                    horizontalalignment='right',
                    verticalalignment='center')

        # write data source
        pyplot.text(1.1*max_value,
                    0.05 * k,
                    self.data_source,
                    fontsize=9,
                    color='#BBBBBB',
                    horizontalalignment='right',
                    verticalalignment='center')

        # write names and values of each bar
        for i in range(k):
            pyplot.text(self.values[i] - 0.01*max_value,
                        y_pos[i],
                        self.names[i],
                        fontsize=8,
                        fontweight='bold',
                        horizontalalignment='right',
                        verticalalignment='center')
            pyplot.text(self.values[i] + 0.01*max_value,
                        y_pos[i],
                        str('{:,}'.format(self.values[i])),
                        fontsize=8,
                        horizontalalignment='left',
                        verticalalignment='center')
        self.fig.canvas.draw_idle()
        self.fig.canvas.start_event_loop(0.02)
        # pyplot.pause(0.01)



# Create a list of 10 Bar objects; sort them; and print them.
def main():

    # create the bar chart
    title = 'The 10 most populous cities'
    x_axis = 'Population (thousands)'
    source = 'Source: United Nations'
    chart = BarChart(title, x_axis, source)

    # add the bars and caption to the bar chart
    chart.add('Tokyo',       38194, 'East Asia')
    chart.add('Delhi',       27890, 'South Asia')
    chart.add('Shanghai',    25779, 'East Asia')
    #chart.add('Beijing',     22674, 'East Asia')
    chart.add('Mumbai',      22120, 'South Asia')
    chart.add('São Paulo',   21698, 'Latin America')
    chart.add('Mexico City', 21520, 'Latin America')
    chart.add('Osaka',       20409, 'East Asia')
    chart.add('Cairo',       19850, 'Middle East')
    chart.add('Dhaka',       19633, 'South Asia')
    chart.set_caption('2018')

    # draw the bar chart
    chart.draw()
    chart.save('test.png')
    chart.save('test.pdf')
    chart.leave_window_open()

if __name__ == '__main__':
    main()


