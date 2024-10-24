/*
 * Copyright 2004 - 2013 Wayne Grant
 *           2013 - 2024 Kai Kramer
 *
 * This file is part of KeyStore Explorer.
 *
 * KeyStore Explorer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * KeyStore Explorer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with KeyStore Explorer.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kse.gui.jar;

import java.awt.*;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Custom cell renderer for the cells of the Jar Information table of DJarInfo.
 */
public class JarInfoTableCellRend extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private static ResourceBundle res = ResourceBundle.getBundle("org/kse/gui/jar/resources");

    /**
     * Returns the rendered cell for the supplied value and column.
     *
     * @param jtJarInfo  The JTable
     * @param value      The value to assign to the cell
     * @param isSelected True if cell is selected
     * @param row        The row of the cell to render
     * @param col        The column of the cell to render
     * @param hasFocus   If true, render cell appropriately
     * @return The rendered cell
     */
    @Override
    public Component getTableCellRendererComponent(JTable jtJarInfo, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int col) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(jtJarInfo, value, isSelected, hasFocus, row, col);
        if (cell.getText().isEmpty()) {
            cell.setText("-");
            }
        cell.setHorizontalAlignment(CENTER);
        if (col == 1) {
            cell.setText(MessageFormat.format(res.getString("JarInfoTableCellRend.Size.text"), value));
        }

        if (col < jtJarInfo.getColumnCount() - 1 ) {
            cell.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
        } else {
            cell.setBorder(null);
        }

        return cell;
    }
}
