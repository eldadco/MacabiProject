package PageUtills;

import lombok.Getter;

public enum TabsIndex {
    FIRST(0), SECOND(1), THIRD(2), FOURTH(3);
    @Getter
    int index;

    TabsIndex(int tabsIndex) {
        this.index = tabsIndex;
    }
}
