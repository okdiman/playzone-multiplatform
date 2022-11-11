//
//  Color + Custom.swift
//  iosApp
//
//  Created by Дмитрий Окунев on 08.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    static let backgroundPrimary = Color("backgroundPrimaryColor")
    static let textPrimary = Color("primaryTextColor")
    static let backgroundSecondary = Color("secondaryBackgroundColor")
    static let textSecondary = Color("secondaryTextColor")
    static let textTintColorPrimary = Color("tintColor")
    static let textAction = Color("textActionColor")
    
    init(hex: UInt, alpha: Double = 1){
        self.init(
            .sRGB,
        red: Double((hex >> 16) & 0xff) / 255,
        green: Double((hex >> 08) & 0xff) / 255,
        blue: Double((hex >> 00) & 0xff) / 255,
        opacity: alpha)
    }
}
